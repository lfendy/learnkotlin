SOURCE = a05_strings.kt
TARGET = a05_strings.jar

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
