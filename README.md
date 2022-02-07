# uri-routing-example

This repo demostrates a Kubernetes application made up of "microservices"
(single web pages) served through Nginx. Each service is run on a different URI
with the same domain name (e.g. `example.com/app1`, `example.com/app2`, and
`example.com/app3`.

## Building/Pushing Images

```bash
$ cd app
$ make build
$ cd ..
```

## Deploying to OpenShift

```bash
$ oc new-project url-rewrite-example
$ helm install url-rewrite-example .
```
