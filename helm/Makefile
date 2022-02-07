.PHONY: install test uninstall

install:
	helm install url-rewrite-example .

test:
	helm template --release-name url-rewrite-example .

uninstall:
	helm uninstall url-rewrite-example
