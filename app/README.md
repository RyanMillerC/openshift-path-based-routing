# Example APIs

This directory contains code to build 3 example Spring Boot REST APIs. All
three API are functionally identical however they serve different data sets.
They all use the same Spring Boot project under `_template`. Each theme park
directory contains only the delta required to modify the Spring Boot project
with a different data set and container image name. The template application
code is based on [this
repo](https://github.com/tkgregory/spring-boot-api-example)).

These APIs serve roller coaster data from 3 theme parks in the greater D.C.
area: Hershey Park, Kings Dominion, and Six Flags. Each features the following
endpoints:

* get all rides - GET [/ride](http://localhost:8080/ride) to get a list of all the rides
* get specific ride - GET [/ride/${id}](http://localhost:8080/ride/1) to get a specific ride
* create ride - POST JSON to [/ride](http://localhost:8080/ride) to create a new ride

## Requirements

To build, you will need:

* Java 8 or 11
* Podman (or Docker)

**NOTE:** The API template uses `gradlew` to build containers. If using Podman,
you must create a symlink in your `PATH` that links `docker` -> `podman`. On
RHEL 8, the command is `ls -s /usr/bin/podman /usr/bin/docker`.

## Building

To build the JARs and bundle into container images, run:

```bash
./build.sh
```

Validate the container images have been created with:

```bash
$ podman image ls
REPOSITORY                TAG            IMAGE ID      CREATED       SIZE
localhost/theme-park-api  six-flags      dc8cb327f880  21 hours ago  517 MB
localhost/theme-park-api  kings-dominion 0c273be06662  21 hours ago  517 MB
localhost/theme-park-api  hersey-park    25c1d717195a  21 hours ago  517 MB
```
