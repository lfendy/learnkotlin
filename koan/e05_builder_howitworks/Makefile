SOURCE = e05_builder_howitworks.kt
TARGET = e05_builder_howitworks.jar

$(TARGET):
	kotlinc $(SOURCE) -include-runtime -d $(TARGET)

clean:
	rm -rf $(TARGET)

.PHONY: build
build: $(TARGET)

.PHONY: run
run: $(TARGET)
	java -ea -jar $(TARGET)

PHONY: crun
crun: clean run
