SOURCE = a01_hello.kt
TARGET = a01_hello.jar

$(TARGET):
	kotlinc $(SOURCE) -include-runtime -d $(TARGET)

clean:
	rm -rf $(TARGET)

.PHONY: build
build: $(TARGET)

.PHONY: run
run: $(TARGET)
	java -jar $(TARGET)
