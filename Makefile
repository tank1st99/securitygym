.PHONY: devbuild
devbuild:
	docker-compose -f docker-compose.dev.yaml build

.PHONY: devrun
devrun:
	docker-compose -f docker-compose.dev.yaml up

.PHONY: imagesbuild
imagesbuild:
	docker build -t security-gym-python -f images/python/Dockerfile .
	docker build -t security-gym-javascript -f images/javascript/Dockerfile .
	docker build -t security-gym-golang -f images/golang/Dockerfile .
	docker build -t security-gym-java -f images/java/Dockerfile .

.PHONY: prodbuild
prodbuild:
	docker-compose -f docker-compose.prod.yaml build

.PHONY: prodrun
prodrun:
	docker-compose -f docker-compose.prod.yaml up
