SOURCE = MyDate.kt d04_delegate_howitworks.kt
TARGET = d04_delegate_howitworks.jar

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
