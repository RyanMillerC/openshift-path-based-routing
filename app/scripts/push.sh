#!/bin/bash

set -e

# Set this to the container image name that will be pushed to. DO NOT INCLUDE
# A TAG. Multiple tags will be pushed for this image, one for each API.
CONTAINER_IMAGE_NAME='quay.io/rymiller/theme-park-api'

API_NAMES=(
    'hershey-park'
    'kings-dominion'
    'six-flags'
)

for API in ${API_NAMES[@]} ; do
    echo "Pushing '${CONTAINER_IMAGE_NAME}:${API}'..."
    skopeo copy "containers-storage:localhost/theme-park-api:${API}" \
                "docker://${CONTAINER_IMAGE_NAME}:${API}"
    echo "Done pushing '${CONTAINER_IMAGE_NAME}:${API}'!"
done
