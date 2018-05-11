package se.lexicon.library.services.books;

import java.util.List;

import se.lexicon.library.domain.Book;

public interface BookManagementService {
	public void createBook(Book newBook);

	public void updateBook(Book updatedBook) throws BookNotFoundException;

	public Book searchForBookById(String bookId) throws BookNotFoundException;

	public List<Book> searchForBooksByTitle(String title);

	public List<Book> searchForBooksByAuthor(String author);

	public void deleteBook(Book book) throws BookNotFoundException;

}
