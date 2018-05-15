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
		bookRepository.save(newBook);
		return newBook;
	}

	@Override
	public Book updateBook(Book updatedBook) throws BookNotFoundException {
		bookRepository.save(updatedBook);
		return updatedBook;
	}

	@Override
	public Optional<Book> searchForBookById(String bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchForBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchForBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Integer bookId) throws EmptyResultDataAccessException {
		// TODO Auto-generated method stub

	}

}
