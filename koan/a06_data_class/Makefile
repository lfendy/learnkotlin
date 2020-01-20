SOURCE = a06_data_class.kt
TARGET = a06_data_class.jar

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
