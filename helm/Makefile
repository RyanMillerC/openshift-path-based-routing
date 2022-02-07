.PHONY: install test uninstall

install:
	helm install helm-template .

test:
	helm template --release-name helm-template .

uninstall:
	helm uninstall helm-template
