# openshift-url-rewriting-example

This repo demostrates OpenShift 4 URL rewriting for a application designed made
up of "microservices" (single web pages) served through Nginx containers. Each
application service is run on a different */path* with the same domain name.
Each application service is a separarte deployment matched to separate
ClusterIP K8s service.

| Ingress (External)                    | Service (Internal)              |
| ------------------------------------- | ------------------------------- |
| `https://example.com/app1/index.html` | `app1.namespace.svc/index.html` |
| `https://example.com/app2/index.html` | `app2.namespace.svc/index.html` |
| `https://example.com/app3/index.html` | `app3.namespace.svc/index.html` |

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
