package se.lexicon.library.restcontrollers;

import java.util.List;

import se.lexicon.library.domain.Book;

public class BookCollection {
	List<Book> books;

	public BookCollection() {
		super();
	}

	public BookCollection(List<Book> books) {
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
		return "BookCollection [books=" + books + "]";
	}

}
