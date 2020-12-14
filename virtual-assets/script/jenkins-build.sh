SOAAutomaticDir=C:/SoaAutomaticTestForPDA/
soavirt_workspace=${SOAAutomaticDir}virtualize_workspace/
SOAProgramDir="C:/Program Files/Parasoft/SOAtest & Virtualize/2020.2/"
JenkinsWorkspace=${WORKSPACE}
PDAvirtualAssetsSourceDir=${JenkinsWorkspace}/virtual-assets/

cd "${SOAProgramDir}" || exit
rm -rf ${soavirt_workspace}VirtualAssets/PDA/
cp -r "${PDAvirtualAssetsSourceDir}" ${soavirt_workspace}VirtualAssets/PDA
echo "Start Start virtual server and deploy assets ..."
# Start virtual server and deploy assets.
cmd /c start virtualizecli -startServer -data ${soavirt_workspace} -localsettings ${SOAAutomaticDir}soa.properties