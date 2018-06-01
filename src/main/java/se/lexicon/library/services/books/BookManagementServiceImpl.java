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
public class BookManagementServiceImpl implements BookManagementService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(Book newBook) throws NotUniqueException {
		if (bookRepository.findByISBNLocationLoanPeriod(
				newBook.getIsbn(), newBook.getLocation(),
				newBook.getLoanPeriod()).isPresent() ) {
			throw new NotUniqueException("Book with specified ISBN, location and loan period already exists, please use clone to make a copy!");
		}
		return bookRepository.save(newBook);
	}

	@Override
	public Book cloneBook(Integer bookId) throws BookNotFoundException {

		Optional<Book> foundBook = bookRepository.findById(bookId);
		if (foundBook.isPresent()) {
			Book newCopy = new Book(foundBook.get());
			return bookRepository.save(newCopy);
		} else {
			throw new BookNotFoundException("Book not found");

		}

	}

	@Override
	public Book updateBook(Book updatedBook) throws BookNotFoundException {
		if (null !=bookRepository.findById(updatedBook.getId()) ) {
			return bookRepository.save(updatedBook);
		} else {
			throw new BookNotFoundException("Book not found");

		}
	}

	@Override
	public Optional<Book> searchForBookById(Integer bookId) {
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

		return bookRepository.findByAuthor(author);
		
	}

	@Override
	public List<Book> searchForBooksLike(Book book) {

		return bookRepository.findLikeISBNTitleAuthor(book.getIsbn()+"%", book.getTitle()+"%", book.getAuthor()+"%");
		
	}
	
	public List<Book> getAll() {

		return bookRepository.findAll();
	}

	@Override
	public void deleteBook(Integer bookId) throws EmptyResultDataAccessException {

		bookRepository.deleteById(bookId);
	}

}
