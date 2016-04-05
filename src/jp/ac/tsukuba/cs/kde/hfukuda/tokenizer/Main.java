package jp.ac.tsukuba.cs.kde.hfukuda.tokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Main {
	private Main() {}

	public static void main(final String[] args) throws IOException {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		try (final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!tokenizer.canTokenize(line)) {
					System.out.println("N/A");
					continue;
				}
				System.out.println(String.join("\t", tokenizer.tokenize(line)));
			}
		}
	}
}
