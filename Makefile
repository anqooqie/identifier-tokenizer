bin: $(shell find src -name '*.java')
	rm -rf '$@'
	mkdir '$@'
	find src -name '*.java' -print0 | xargs -0 javac -cp '$@' -d '$@' -encoding UTF-8

identifier-tokenizer.jar: bin
	jar cf '$@' -C '$<' .

.PHONY: test
test: bin local/bin/bats
	local/libexec/bats test/run.bats

local/bin/bats:
	git clone 'https://github.com/sstephenson/bats.git' tmp/bats
	tmp/bats/install.sh local
	rm -rf tmp/bats

.PHONY: clean
clean:
	git clean -X -d -f -f

.PHONY: force
force:
	$(MAKE) clean
	$(MAKE)
