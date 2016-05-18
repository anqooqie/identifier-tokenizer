package jp.ac.tsukuba.cs.kde.hfukuda.identifier_tokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class Main {
	private Main() {}

	public static void main(final String[] args) throws IOException {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		try (final InputStreamReader isr = new InputStreamReader(System.in, StandardCharsets.UTF_8);
				final BufferedReader br = new BufferedReader(isr)) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!tokenizer.canTokenize(line)) {
					System.out.println();
					continue;
				}
				System.out.println(String.join("\t", tokenizer.tokenize(line)));
			}
		}
	}
}
