#!/bin/bash
#
# Push last build to the latest directory.
#

readonly DEMO_APP_LATEST_WAR_FILE="parasoft-demo-app-1.0.0.war"
readonly DEMO_APP_LATEST_SOATEST_TESTS_FILE="soatest-tests-1.0.0.zip"
readonly DEMO_APP_LATEST_SELENIC_TESTS_FILE="selenic-tests-1.0.0.zip"
readonly DEMO_APP_LATEST_VIRTUALIZE_ASSETS_FILE="virtualize-assets-1.0.0.zip"
readonly DEMO_APP_BUILDS_DIR_LOC="/usr/local/nexus/sonatype-work/nexus/storage/pda-snapshots/com/parasoft/demoapp/com.parasoft.demoapp"

cd "${DEMO_APP_BUILDS_DIR_LOC}"
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

readonly LATEST_DIR="latest"
mkdir -p "${LATEST_DIR}"
rm -rf ${LATEST_DIR}/*
readonly latest_war_file_loc="${DEMO_APP_BUILDS_DIR_LOC}/${LATEST_DIR}/${DEMO_APP_LATEST_WAR_FILE}"
readonly latest_soatest_file_loc="${DEMO_APP_BUILDS_DIR_LOC}/${LATEST_DIR}/${DEMO_APP_LATEST_SOATEST_TESTS_FILE}"
readonly latest_selenic_file_loc="${DEMO_APP_BUILDS_DIR_LOC}/${LATEST_DIR}/${DEMO_APP_LATEST_SELENIC_TESTS_FILE}"
readonly latest_virtualize_file_loc="${DEMO_APP_BUILDS_DIR_LOC}/${LATEST_DIR}/${DEMO_APP_LATEST_VIRTUALIZE_ASSETS_FILE}"
cp -f ${last_build_dir}/*.war "${latest_war_file_loc}"
cp -f ${last_build_dir}/*-soatest.tests.zip "${latest_soatest_file_loc}"
cp -f ${last_build_dir}/*-selenic.tests.zip "${latest_selenic_file_loc}"
cp -f ${last_build_dir}/*-virtualize.assets.zip "${latest_virtualize_file_loc}"

cd "${LATEST_DIR}"
if [[ -f "${DEMO_APP_LATEST_WAR_FILE}" ]]; then
  sha256sum -b "${DEMO_APP_LATEST_WAR_FILE}" > "build-${VERSION}-sha256sums.txt"
else
  echo "ERROR: ${DEMO_APP_LATEST_WAR_FILE} file is not available in the ${LATEST_DIR} directory."
  exit 1
fi
if [[ -f "${DEMO_APP_LATEST_SOATEST_TESTS_FILE}" ]]; then
  sha256sum -b "${DEMO_APP_LATEST_SOATEST_TESTS_FILE}" >> "build-${VERSION}-sha256sums.txt"
else
  echo "ERROR: ${DEMO_APP_LATEST_SOATEST_TESTS_FILE} file is not available in the ${LATEST_DIR} directory."
  exit 1
fi
if [[ -f "${DEMO_APP_LATEST_SELENIC_TESTS_FILE}" ]]; then
  sha256sum -b "${DEMO_APP_LATEST_SELENIC_TESTS_FILE}" >> "build-${VERSION}-sha256sums.txt"
else
  echo "ERROR: ${DEMO_APP_LATEST_SELENIC_TESTS_FILE} file is not available in the ${LATEST_DIR} directory."
  exit 1
fi
if [[ -f "${DEMO_APP_LATEST_VIRTUALIZE_ASSETS_FILE}" ]]; then
  sha256sum -b "${DEMO_APP_LATEST_VIRTUALIZE_ASSETS_FILE}" >> "build-${VERSION}-sha256sums.txt"
else
  echo "ERROR: ${DEMO_APP_LATEST_VIRTUALIZE_ASSETS_FILE} file is not available in the ${LATEST_DIR} directory."
  exit 1
fi
echo "Latest build ${latest_build_dir} is now available in the ${LATEST_DIR} directory."
