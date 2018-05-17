package se.lexicon.library.restcontrollers;

import java.util.List;

import se.lexicon.library.domain.Book;

public class BooksWrapper {
	List<Book> books;

	public BooksWrapper() {
		super();
	}

	public BooksWrapper(List<Book> books) {
		super();
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BooksWrapper [books=" + books + "]";
	}

}
