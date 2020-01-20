hello.jar:
	kotlinc hello.kt -include-runtime -d hello.jar

clean:
	rm -rf hello.jar

.PHONY: build
build: hello.jar

.PHONY: run
run: hello.jar
	java -jar hello.jar

script:
	kotlinc -script hello.kts --
