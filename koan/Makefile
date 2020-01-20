PROJECT?=hello

.PHONY: init
init:
	mkdir -p $(PROJECT) && \
		sed 's/###PROJECT###/$(PROJECT)/g' Makefile.template > $(PROJECT)/Makefile && \
		cp project.kt.template $(PROJECT)/$(PROJECT).kt
