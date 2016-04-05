bin: $(shell find src -name '*.java')
	rm -rf '$@'
	mkdir '$@'
	find src -name '*.java' -print0 | xargs -0 javac -cp '$@' -d '$@' -encoding UTF-8

identifier-tokenizer.jar: bin
	jar cf '$@' -C '$<' .

.PHONY: test
test:
	test/run.bats

.PHONY: clean
clean:
	git clean -X -d -f

.PHONY: force
force:
	$(MAKE) clean
	$(MAKE)
