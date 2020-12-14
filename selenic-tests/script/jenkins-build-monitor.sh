workspace=$WORKSPACE #from jenkins（Remote root directory）
PDASourceCodeDir="${workspace}/parasoft-demo-app/"
JtestProgramDir="C:/SelenicAutomaticTestForPDA/jtest/"
JTESTGradleInitScript="${JtestProgramDir}integration/gradle/init.gradle"
selenicAutomaticWorkspace="C:/SelenicAutomaticTestForPDA/"

# Obtain basical coverage data
cd ${PDASourceCodeDir} || exit
echo "Use jtst for base coverage ..."
./gradlew assemble jtest-monitor -I "${JTESTGradleInitScript}" -Djtest.settings="${selenicAutomaticWorkspace}jtest.properties"

# Unpack monitor.zip
cd ${PDASourceCodeDir}build/jtest || exit
unzip -qo monitor.zip