.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

build-run: build run

.PHONY: build
