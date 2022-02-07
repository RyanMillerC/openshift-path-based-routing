.PHONY: build

build:
	buildah bud -t registry.taco.moe/url-rewrite-example/app1:latest app1
	buildah push registry.taco.moe/url-rewrite-example/app1:latest
	buildah bud -t registry.taco.moe/url-rewrite-example/app2:latest app2
	buildah push registry.taco.moe/url-rewrite-example/app2:latest
	buildah bud -t registry.taco.moe/url-rewrite-example/app3:latest app3
	buildah push registry.taco.moe/url-rewrite-example/app3:latest
