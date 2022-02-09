# openshift-url-rewriting-example

This repo demostrates OpenShift 4 URL rewriting for a application designed made
up of "microservices" (single web pages) served through Nginx containers. Each
service is run on a different URI with the same domain name (e.g.
`example.com/app1`, `example.com/app2`, and `example.com/app3`.

## Building/Pushing Images

```bash
$ cd app
$ make build
```

## Deploying to OpenShift

```bash
$ cd helm
$ oc new-project url-rewrite-example
$ make install
```
