package se.lexicon.library.services.books;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import se.lexicon.library.domain.Book;

public interface BookManagementService {
	public Book createBook(Book newBook) throws NotUniqueException;

	public Book cloneBook(Integer bookId) throws BookNotFoundException;

	public Book updateBook(Book updatedBook) throws BookNotFoundException;

	public Optional<Book> searchForBookById(Integer bookId) throws BookNotFoundException;

	public List<Book> searchForBooksByIsbn(String isbn);

	public List<Book> searchForBooksByTitle(String title);

	public List<Book> searchForBooksByAuthor(String author);

	public List<Book> getAll();

	public void deleteBook(Integer bookId) throws EmptyResultDataAccessException;


}
