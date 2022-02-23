#!/bin/bash
#
# This is a hack so I don't need to have 3 copies of the application. Since all
# three APIs are the same (with only data being the difference) this script
# uses the application as a template and copies the differences between each
# API at build time.
#

set -e

BUILD_DIR='./spring-boot-api-example'
THEME_PARKS=(
    './api/hershey_park'
    './api/kings_dominion'
    './api/six_flags'
)

[[ -d "${BUILD_DIR}" ]] && rm -rf "${BUILD_DIR}"

for THEME_PARK in ${THEME_PARKS[@]} ; do
    echo "Building ${THEME_PARK}..."
    cp -r ./_template "${BUILD_DIR}"
    cp "${THEME_PARK}/ThemeParkApplication.java" "${BUILD_DIR}/src/main/java/com/tomgregory"
    cp "${THEME_PARK}/build.gradle" "${BUILD_DIR}"
    cd "${BUILD_DIR}"
    ./gradlew assemble docker
    cd ..
    rm -rf "${BUILD_DIR}"
    echo "Done building ${THEME_PARK}!"
done
