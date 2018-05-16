package se.lexicon.library.services.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.library.domain.Book;
import se.lexicon.library.repositories.BookRepository;

@Transactional
@Service
public class BookManagementServiceMockImpl implements BookManagementService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book createBook(Book newBook) {

		return bookRepository.save(newBook);
	}

	@Override
	public Book cloneBook(String isbn) throws BookNotFoundException {

		List<Book> foundBook = bookRepository.findByIsbn(isbn);
		System.out.println(isbn+foundBook);
		if (!foundBook.isEmpty()) {
			Book newCopy = new Book(foundBook.get(0));
			return bookRepository.save(newCopy);
		} else {
			throw new BookNotFoundException();

		}
		
	}

	@Override
	public Book updateBook(Book updatedBook) throws BookNotFoundException {
		
		return bookRepository.save(updatedBook);
	}

	@Override
	public Optional<Book> searchForBookById(Integer bookId) throws BookNotFoundException {
		return bookRepository.findById(bookId);
	}

	
	
	@Override
	public List<Book> searchForBooksByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	public List<Book> searchForBooksByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Book> searchForBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Integer bookId) throws EmptyResultDataAccessException {
		bookRepository.deleteById(bookId);
	}

}
