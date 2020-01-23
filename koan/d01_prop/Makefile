SOURCE = d01_prop.kt
TARGET = d01_prop.jar

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
