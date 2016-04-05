package jp.ac.tsukuba.cs.kde.hfukuda.tokenizer;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IdentifierTokenizer {
	public IdentifierTokenizer() {}

	private static final Pattern IS_VALID_ASCII_NAME = Pattern.compile("^[A-Za-z_][0-9A-Za-z_]*$");
	public boolean canTokenize(final String identifier) {
		return IS_VALID_ASCII_NAME.matcher(identifier).find();
	}
	public List<String> tokenize(final String identifier) {
		if (!this.canTokenize(identifier)) throw new IllegalArgumentException("Not valid ASCII name: " + identifier);

		return Stream.of(identifier.split("_+"))
				.filter(underscoreSeparated -> !underscoreSeparated.isEmpty())
				.flatMap(underscoreSeparated -> {
					final List<String> words = Stream.of(
							underscoreSeparated.replaceAll(
									"([A-Z][0-9A-Z]*)(?=[A-Z]|$)",
									"_!$1_"
							).split("_+")
					).filter(unit -> !unit.isEmpty())
					.flatMap(unit -> unit.startsWith("!")
							? Stream.of(unit.substring(1))
							: Stream.of(
									unit.replaceAll(
											"([A-Z][0-9a-z]+)",
											"_$1_"
									).split("_+")
							).filter(word -> !word.isEmpty())
					).collect(Collectors.toList());
					if (words.size() >= 2 && words.get(0).matches("^[0-9]+$")) {
						words.set(1, words.get(0) + words.get(1));
						return words.stream().skip(1);
					} else {
						return words.stream();
					}
				}).collect(Collectors.toList());
	}
}
