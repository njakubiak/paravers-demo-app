#!/bin/bash
#
# Archive and publish parasoft-demo-app SOAtest tests and Selenic UI tests to Nexus.
# Jenkins build parameters:
#   PUBLISH_TO_NEXUS - required for publish to nexus repository.
#   NEXUS_URL - required, defaults to http://nexus.parasoft.com.cn:8081/nexus, and pda-snapshots repository
#               (Maven2, Repository Policy: Release, Deployment Policy: Allow Redeploy) should be created first.
#   NEXUS_USERNAME - required for publish to nexus repository.
#   NEXUS_PASSWORD - required for publish to nexus repository.
#   REBUILD_PDA_MAVEN_METADATA_NEXUS_TASK_ID
#     - required, create a Nexus scheduled task(rebuild-pda-maven-metadata) to rebuild Maven metadata of
#       pda-snapshots repository, the task ID can be got by accessing URL: ${NEXUS_URL}/service/local/schedules.
#   DO_NOT_CLEAN_GRADLE - do not clean files generated by Gradle task.
#   DO_NOT_BUILD - show Gradle tasks only.
# Jenkins environment variables:
#   BUILD_NUMBER
#   GIT_COMMIT
#

set -e         
#set -u
set -o pipefail

die () {
    echo
    echo "$*"
    echo
    exit 1
}

declare -a build_flags
build_flags=(--stacktrace)

if [[ "${DO_NOT_CLEAN_GRADLE}" != "true" ]]; then
  build_flags+=(clean)
fi

if [[ "${DO_NOT_BUILD}" == "true" ]]; then
  build_flags+=(tasks)
else 
  if [[ "${PUBLISH_TO_NEXUS}" == "true" ]]; then
    build_flags+=(publishDemoAppTestsPublicationToSnapshotsRepository)

    if [[ -n "${NEXUS_URL}" ]]; then
      build_flags+=(-PpdaSnapshotsRepoUrl="${NEXUS_URL}/content/repositories/pda-snapshots/")
    fi

    if [[ -n "${NEXUS_USERNAME}" ]]; then
      build_flags+=(-PrepoUsername="${NEXUS_USERNAME}")
    else
      die "ERROR: Need to specify the user name for publishing to Nexus repository."
      exit 1
    fi

    if [[ -n "${NEXUS_PASSWORD}" ]]; then
      build_flags+=(-PrepoPassword="${NEXUS_PASSWORD}")
    fi
  else
    build_flags+=(distSoatestTestsZip distSelenicTestsZip)
  fi
fi

if [[ -n "${BUILD_NUMBER}" ]]; then
  build_flags+=(-PjenkinsBuildNumber="${BUILD_NUMBER}")
fi

if [[ -n "${GIT_COMMIT}" ]]; then
  build_flags+=(-PgitCommitHash="${GIT_COMMIT:0:11}")
fi

echo "Archive and publish SOAtest tests and Selenic UI tests..."
echo "Build flags: ${build_flags[@]}"
bash ./gradlew "${build_flags[@]}"

if [[ "${PUBLISH_TO_NEXUS}" == "true" ]]; then
  echo "Rebuild PDA Maven metadata files..."
  curl -u "${NEXUS_USERNAME}:${NEXUS_PASSWORD}" \
  "${NEXUS_URL}/service/local/schedule_run/${REBUILD_PDA_MAVEN_METADATA_NEXUS_TASK_ID}"
  sleep 10s
  echo
fi
