SOURCE = a08_smart_casts.kt
TARGET = a08_smart_casts.jar

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
