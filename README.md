# OpenShift Path-Based Routing Demo

This repo demostrates OpenShift 4 path-based routing for an application made up
of 3 REST APIs (microservices). The demo application serves roller coaster data
from 3 theme parks in the greater Washington D.C. area: Hershey Park, Kings
Dominion, and Six Flags. All three APIs are served through a single sub-domain
with each API served on a different */path*. Each API runs a different
container image in a separate Pod/Deployment. Each API has it's own Service and
Ingress objects. This mapping looks like:

| Ingress (External)                        | Service (Internal)                          |
| ----------------------------------------- | ------------------------------------------- |
| `https://example.com/hershey-park/ride`   | `https://hershey-park.namespace.svc/ride`   |
| `https://example.com/kings-dominion/ride` | `https://kings-dominion.namespace.svc/ride` |
| `https://example.com/six-flags/ride     ` | `https://six-flags.namespace.svc/ride`      |

All three API are functionally identical however they serve different data
sets. They are all based on the same Java (Spring Boot) project under
`./app/_template`. Each theme park directory contains only the delta required
to modify the Spring Boot project with a different data set and container image
name. The template application code is based on [this
repo](https://github.com/tkgregory/spring-boot-api-example)). Each API provides the following endpoints:

* get all rides - GET [/ride](http://localhost:8080/ride) to get a list of all the rides
* get specific ride - GET [/ride/${id}](http://localhost:8080/ride/1) to get a specific ride
* create ride - POST JSON to [/ride](http://localhost:8080/ride) to create a new ride

Pre-built container images are available
[here](https://quay.io/rymiller/theme-park-api). You don't need to build the
container images yourself to run this demo. If you really want to build them
yourself, the code to build the images is available under `./app` in this repo.

## Requirements

* OpenShift (CodeReady Containers is fine)
* Machine with `oc` and `helm` installed that can reach the OpenShift API

## Deploying to Demo to OpenShift

1. Clone this repo to local machine
2. Replace `dnsName` value in `values.yaml` with a valid DNS name for your cluster
3. `$ oc new-project url-rewrite-example`
4. `$ make install`
