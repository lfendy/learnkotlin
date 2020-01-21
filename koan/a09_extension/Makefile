SOURCE = a09_extension.kt
TARGET = a09_extension.jar

$(TARGET):
	kotlinc $(SOURCE) -include-runtime -d $(TARGET)

clean:
	rm -rf $(TARGET)

.PHONY: build
build: $(TARGET)

.PHONY: run
run: $(TARGET)
	java -jar $(TARGET)

PHONY: crun
crun: clean run
