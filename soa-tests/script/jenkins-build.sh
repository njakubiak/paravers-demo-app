SOAAutomaticDir=C:/SoaAutomaticTestForPDA/
soavirt_workspace=C:/Users/parasoftcd/parasoft/soavirt_workspace
SOAWorkspace=C:/Users/parasoftcd/parasoft/soavirt_workspace/
SOAProgramDir="C:/Program Files/Parasoft/SOAtest & Virtualize/2020.2/"
JenkinsWorkspace=C:/jenkins/workspace/pda.soa.test/
PDASourceDir=C:/jenkins/workspace/pda.soa.test/parasoft-demo-app/
PDASOATestsSourceDir=C:/jenkins/workspace/pda.soa.test/soa-tests/
PDAUrl=localhost:8080

JtestProgramDir=C:/Parasoft/jtest/
JTESTGradleInitScript=${JtestProgramDir}integration/gradle/init.gradle
PDASourceDir=${JenkinsWorkspace}parasoft-demo-app/
ReportDir=${PDASOATestsSourceDir}report/


cd ${PDASourceDir} || exit
echo "Use Jtest for base coverage ..."
./gradlew assemble jtest-monitor -I "${JTESTGradleInitScript}" -Djtest.settings=${SOAAutomaticDir}jtest.properties

# unpack monitor.zip
cd ${PDASourceDir}build/jtest || exit
unzip -qo monitor.zip

cd ${SOAAutomaticDir} || exit
rm -rf RuntimeData
rm -rf pda-db
mkdir RuntimeData

# Download the latest builded PDA
echo "Downloading the latest builded PDA..."
if [ "$CURRENT_NODE" = "$WIN_NODE" ]; then
  wget -nv -e robots=off -r -nd -np -A '*.war' -O pda_latest_version.war -P "${selenicAutomaticWorkspace}" "http://nexus.parasoft.com.cn:8081/nexus/content/repositories/pda-snapshots/com/parasoft/demoapp/com.parasoft.demoapp/last-build/"
fi
echo "Downloading completes"

echo "Start up PDA ..."
cmd /c start java -jar -javaagent:"${PDASourceDir}build/jtest/monitor/agent.jar"=settings="${PDASourceDir}build/jtest/monitor/agent.properties",runtimeData="${SOAAutomaticDir}RuntimeData" pda_latest_version.war

corretPDAStatus="302"

for(( i=1; i<=30; i++ ))
do {
	echo "Verify the start is successful ----------------- ${i} try"
	echo "Try to connect PDA project ${PDAUrl}"
	pdaStatus=$(curl -I -m 10 -o /dev/null -s -w %\{http_code\}  $PDAUrl)
	echo "Current state of PDA project(http code): ${pdaStatus}"
	if [ "$pdaStatus" = $corretPDAStatus ] ; then
		echo "Successfully connect the PDA project. The PDA project was start up successfully"
		break
	else
		echo "Connection will be tried again after 10 seconds..."
		sleep 10
	fi
}
done

cd "${SOAProgramDir}" || exit
rm -rf ${SOAWorkspace}soa-tests
cp -r ${PDASOATestsSourceDir} ${SOAWorkspace}soa-tests
echo "Start to run SOA regression tests..."
# Run tests and send result to DTP.
cmd /c soatestcli.exe -config "user://Demo Configuration" -data "${soavirt_workspace}" -resource "soa-tests" -report "${ReportDir}" -localsettings "${SOAAutomaticDir}soa.properties" -publish -fail
testStatus=$?
echo "Test status code is ${testStatus}"

# Send coverage to DTP.
echo "Send coverage to DTP..."
${JtestProgramDir}jtestcli -staticcoverage "${PDASourceDir}build/jtest/monitor/static_coverage.xml" -runtimecoverage "${SOAAutomaticDir}RuntimeCoverage" -config "builtin://Calculate Application Coverage" -settings "${SOAAutomaticDir}jtest.properties" -publish

## Shut down PDA
cd ${SOAAutomaticDir} || exit
echo "Trying to stop PDA ..."
taskkill /F /PID $(cat application.pid)


## Validate wheather PDA shuting down successfully
corretPDAStatus="000"
for(( i=1; i<=30; i++ ))
do {
	echo "Verify shuting down is successful ----------------- ${i} try"
	echo "Try to connect PDA project ${PDAUrl}"
	pdaStatus=$(curl -I -m 10 -o /dev/null -s -w %\{http_code\}  $PDAUrl)
	echo "Current state of PDA project(http code): ${pdaStatus}"
	if [ "$pdaStatus" = $corretPDAStatus ] ; then
		echo "Successfully disconnect the PDA project. The PDA project was stopped successfully"
		break
	else
		echo "Connection will be tried again after 10 seconds..."
		sleep 10
	fi
}
done

if [ "$pdaStatus" != $corretPDAStatus ]; then
	echo "[ERROR] PDA project shut down time exceeds 600s! Please shut down manually."
fi

if [ "$pdaStatus" != $corretPDAStatus ]; then
	echo "PDA project start up time exceeds 600s! Selenic regression tests are no longer tested."
	exit 1
fi

if [ $testStatus != 0 ]; then
	echo "Some tests failed"
	exit 1
fi
