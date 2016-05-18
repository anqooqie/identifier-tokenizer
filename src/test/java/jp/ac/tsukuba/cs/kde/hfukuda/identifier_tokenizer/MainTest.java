package jp.ac.tsukuba.cs.kde.hfukuda.identifier_tokenizer;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MainTest {
	@Test
	public void testUsualPascalCase() {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		assertThat(tokenizer.canTokenize("DoublyLinkedList"), is(true));
		assertThat(tokenizer.tokenize("DoublyLinkedList"), is(Arrays.asList("Doubly", "Linked", "List")));
	}

	@Test
	public void testAcronym() {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		assertThat(tokenizer.canTokenize("JDBCTest"), is(true));
		assertThat(tokenizer.tokenize("JDBCTest"), is(Arrays.asList("JDBC", "Test")));
	}

	@Test
	public void testNumber() {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		assertThat(tokenizer.canTokenize("SSL2TransmissionImplVersion4"), is(true));
		assertThat(tokenizer.tokenize("SSL2TransmissionImplVersion4"), is(Arrays.asList("SSL2", "Transmission", "Impl", "Version4")));
	}

	@Test
	public void testUnderscore() {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		assertThat(tokenizer.canTokenize("KDE_IdentifierTokenizer"), is(true));
		assertThat(tokenizer.tokenize("KDE_IdentifierTokenizer"), is(Arrays.asList("KDE", "Identifier", "Tokenizer")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLeadingNumbers() {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		assertThat(tokenizer.canTokenize("123InvalidIdentifierName"), is(false));
		tokenizer.tokenize("123InvalidIdentifierName");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDollarSign() {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		assertThat(tokenizer.canTokenize("IdentifierNameContaining$"), is(false));
		tokenizer.tokenize("IdentifierNameContaining$");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotASCIICharacter() {
		final IdentifierTokenizer tokenizer = new IdentifierTokenizer();
		assertThat(tokenizer.canTokenize("NotASCIIなIdentifierName"), is(false));
		tokenizer.tokenize("NotASCIIなIdentifierName");
	}
}
