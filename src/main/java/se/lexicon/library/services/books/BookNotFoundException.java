package se.lexicon.library.services.books;

public class BookNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7259656538891062624L;

	public BookNotFoundException(String message) {
		super(message);
	}

}
