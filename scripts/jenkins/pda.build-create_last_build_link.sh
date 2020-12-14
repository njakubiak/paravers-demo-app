#!/bin/bash
#
# Link last build directory to the last-build.
# Jenkins configuration:
# Conditional step (single) -> Boolean condition -> Token: ${ENV,var="PUBLISH_TO_NEXUS"}
#
readonly DEMO_APP_BUILDS_DIR_LOC="/usr/local/nexus/sonatype-work/nexus/storage/pda-snapshots/com/parasoft/demoapp/com.parasoft.demoapp"
cd "${DEMO_APP_BUILDS_DIR_LOC}"

readonly LATEST_DIR="latest"
# Remove checksum files in latest directory.
rm -f ${LATEST_DIR}/*.md5
rm -f ${LATEST_DIR}/*.sha1

readonly METADATA_FILE="maven-metadata.xml"
if [[ -f "${METADATA_FILE}" ]]; then
  VERSION="$(cat "${METADATA_FILE}" | grep -E '<version>.*</version>' | tail -1)"
  VERSION="${VERSION/*<version>}"
  readonly VERSION="${VERSION/<\/version>*}"
  echo "   -> last general version  :  $VERSION"
  readonly last_build_dir="${VERSION}"
else
  echo "   -> last general version  :  none - component not found"
  echo
  exit 1
fi

echo "last_build_dir: ${last_build_dir}"
if [[ ! -d "${last_build_dir}" ]]; then
  echo "ERROR: Last build ${last_build_dir} is not available."
  exit 1
fi

readonly LAST_BUILD_LINK="last-build"
rm -f "${LAST_BUILD_LINK}"
echo "Link ${last_build_dir} to ${LAST_BUILD_LINK}..."
ln -s "${last_build_dir}" "${LAST_BUILD_LINK}"
ls -al "${LAST_BUILD_LINK}"
