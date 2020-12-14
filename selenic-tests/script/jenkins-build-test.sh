# Obtain current enviroment
CURRENT_NODE=$NODE_NAME	#from jenkins
INDUSTRY=$TARGET_INDUSTRY	#from jenkins
WEB_DRIVER=$WEB_DRIVER_USING	#from jenkins
SEND_REPORT=$SEND_REPORT_TO_DTP	#from jenkins
CHROME_WEB_DRIVER="chrome"
FIREFOX_WEB_DRIVER="firefox"
IEXPLORE_WEB_DRIVER="iexplore"
EDGE_WEB_DRIVER="edge"

# Set variables
WIN_NODE="pda.win64.tester"
jtestMonitorAgentJar="C:/jenkins/workspace/pda.selenic.test/parasoft-demo-app/build/jtest/monitor/agent.jar"
jtestMonitorAgentProperties="C:/jenkins/workspace/pda.selenic.test/parasoft-demo-app/build/jtest/monitor/agent.properties"
jtestMonitorStaticCoverage="C:/jenkins/workspace/pda.selenic.test/parasoft-demo-app/build/jtest/monitor/static_coverage.xml"

# Use if statement to estimate if the WIN_NODE exists
if [ ! "$CURRENT_NODE" ]; then
	echo "The running environment(parameter: CURRENT_NODE) of the script was not specified, the valid value can be \`pda.win64.tester\`"
	exit 1
fi

if [ "$CURRENT_NODE" = $WIN_NODE ]; then
	echo "Current environment is ${NODE_NAME}"
else
	echo "The running environment(parameter: CURRENT_NODE) of the script was not specified correctly, the valid value can be \`pda.win64.tester\`"
	exit 1
fi

# Set enviroment variables(maven)
if [ "$CURRENT_NODE" = $WIN_NODE ]; then
	MAVEN_HOME="/cygdrive/C/SelenicAutomaticTestForPDA/apache-maven-3.6.3/bin/"
	JAVA_HOME="/cygdrive/C/Program Files/Java/jdk1.8.0_201/bin/"
fi
export PATH=$MAVEN_HOME:$PATH
export PATH=$JAVA_HOME:$PATH

# Set global variables
workspace=$WORKSPACE #from jenkins（Remote root directory）
pdaSelenicRegressionSourceCodesPath="${workspace}/selenic-tests/"
PDAHomePageUrl=http://localhost:8080
reportPath="${workspace}/selenic-tests/target/report/"
junitTestReport="${reportPath}junit/"

if [ "$CURRENT_NODE" = $WIN_NODE ]; then
	selenicAutomaticWorkspace="C:/SelenicAutomaticTestForPDA/"
	chromeDriverPath="${selenicAutomaticWorkspace}chromedriver.exe"
	firefoxDriverPath="${selenicAutomaticWorkspace}geckodriver.exe"
	IEDriverPath="${selenicAutomaticWorkspace}IEDriverServer.exe"
	edgeDriverPath="${selenicAutomaticWorkspace}msedgedriver.exe"
fi
senenicSoftwarePath="${selenicAutomaticWorkspace}Selenic/"
senenicAgentPath="${senenicSoftwarePath}selenic_agent.jar"
junitTestReport="${reportPath}junit/"
runtimeCoverageDir="${reportPath}runtimecoverage"
JtestProgramDir="C:/SelenicAutomaticTestForPDA/jtest/"

# Enter to workspace(not jenkins worksapce)
cd $selenicAutomaticWorkspace || exit

# Restore the custom workspace
cd $selenicAutomaticWorkspace || exit
rm -rf pda
rm -rf pda_latest_version.war
rm -rf tmp
rm -rf application.pid
rm -rf pda-db
mkdir tmp

cd ${selenicAutomaticWorkspace} || exit
rm -rf RuntimeData
mkdir RuntimeData

# Download the latest builded PDA
echo "Downloading the latest builded PDA..."
if [ "$CURRENT_NODE" = "$WIN_NODE" ]; then
  wget -nv -e robots=off -r -nd -np -A '*.war' -O pda_latest_version.war -P "${selenicAutomaticWorkspace}" "http://nexus.parasoft.com.cn:8081/nexus/content/repositories/pda-snapshots/com/parasoft/demoapp/com.parasoft.demoapp/last-build/"
fi
echo "Downloading completes"

# Start PDA project
cd $selenicAutomaticWorkspace || exit
echo "Trying to start up PDA ..."
if [ "$CURRENT_NODE" = $WIN_NODE ] ; then
	cmd /c start java -jar -javaagent:"${jtestMonitorAgentJar}"=settings="${jtestMonitorAgentProperties}",runtimeData="${selenicAutomaticWorkspace}RuntimeData" pda_latest_version.war
fi

# Verify that the project started successfully
corretPDAStatus="302"

for(( i=1; i<=30; i++ ))
do {
	echo "Verify the start is successful ----------------- ${i} try"
	echo "Try to connect PDA project ${PDAHomePageUrl}"
	pdaStatus=$(curl -I -m 10 -o /dev/null -s -w %\{http_code\}  $PDAHomePageUrl)
	echo "Current state of PDA project(http code): ${pdaStatus}"
	if [ "$pdaStatus" = $corretPDAStatus ] ; then
		echo "Successfully connect the PDA project. The PDA project was started up successfully"
		break
	else
		echo "Connection will be tried again after 10 seconds..."
		sleep 10
	fi
}
done

# Exit directly after starting timeout
if [ "$pdaStatus" != $corretPDAStatus ]; then
	echo "PDA project start up time exceeds 600s! Selenic regression tests are no longer tested."
	exit 1
fi

# Execute the Selenic commands
cd "$pdaSelenicRegressionSourceCodesPath" || exit

# Switch to specified industry and run all test
echo "Switch industry to ${TARGET_INDUSTRY}..."

if [ "$WEB_DRIVER" = $CHROME_WEB_DRIVER ]; then
	Dwebdriver="-Dwebdriver.chrome.driver=${chromeDriverPath}"
fi
if [ "$WEB_DRIVER" = $FIREFOX_WEB_DRIVER ]; then
	Dwebdriver="-Dwebdriver.gecko.driver=${firefoxDriverPath}"
fi
if [ "$WEB_DRIVER" = $IEXPLORE_WEB_DRIVER ]; then
	Dwebdriver="-Dwebdriver.ie.driver=${IEDriverPath}"
fi
if [ "$WEB_DRIVER" = $EDGE_WEB_DRIVER ]; then
	Dwebdriver="-Dwebdriver.edge.driver=${edgeDriverPath}"
fi

echo "Web driver argument is ${Dwebdriver}."

mvn test -Dtest=ChangeIndustry#testChangeIndustry ${Dwebdriver} -DTARGET_INDUSTRY="${INDUSTRY}" -DBASE_URL=${PDAHomePageUrl} -DWEB_DRIVER_USING="${WEB_DRIVER}"
statusOfIndustryChange=$?
if [ $statusOfIndustryChange != 0 ]; then
	echo "Failed to changing industry to ${TARGET_INDUSTRY}."
	exit 1
fi
echo "Switch industry to ${TARGET_INDUSTRY} successfully."

selenicCommand="-DargLine=-javaagent:${senenicAgentPath}=captureDom=true,screenshot=failures,selfHealing=true,collectCoverage=true,coverageAgentHost=localhost,coverageAgentPort=8050,coverageDir=${runtimeCoverageDir}"
mvnScript="bash ${MAVEN_HOME}mvn test ${selenicCommand} ${Dwebdriver} -DTARGET_INDUSTRY="${INDUSTRY}" -DBASE_URL=${PDAHomePageUrl} -DWEB_DRIVER_USING=${WEB_DRIVER}"

echo "Start to run Selenic regression tests..."
echo "Execute the script: ${mvnScript}"

$mvnScript
testStatus=$?
echo "Test status code is ${testStatus}"

if [ "$SEND_REPORT" = true ]; then
	# Send the test report to DTP
  cd ${senenicSoftwarePath} || exit

  java -jar selenic_analyzer.jar -source "${pdaSelenicRegressionSourceCodesPath}" -report "${junitTestReport}" -publish

  # Send coverage to DTP.
  ${JtestProgramDir}jtestcli -staticcoverage "${jtestMonitorStaticCoverage}" -runtimecoverage "${runtimeCoverageDir}" -config "builtin://Calculate Application Coverage" -settings "${selenicAutomaticWorkspace}jtest.properties" -report ${runtimeCoverageDir} -publish
fi

# Stop PDA project
cd $selenicAutomaticWorkspace || exit
echo "Trying to stop PDA ..."
if [ "$CURRENT_NODE" = $WIN_NODE ]; then
	taskkill /F /PID $(cat application.pid)
fi

# Verify that the project stopped successfully
corretPDAStatus="000"
for(( i=1; i<=30; i++ ))
do {
	echo "Verify the stop is successful ----------------- ${i} try"
	echo "Try to connect PDA project ${PDAHomePageUrl}"
	pdaStatus=$(curl -I -m 10 -o /dev/null -s -w %\{http_code\}  $PDAHomePageUrl)
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

if [ $testStatus != 0 ]; then
	echo "Some tests failed"
	exit 1
fi