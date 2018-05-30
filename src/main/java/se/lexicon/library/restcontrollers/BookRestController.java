package se.lexicon.library.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.Book;
import se.lexicon.library.services.books.BookManagementService;
import se.lexicon.library.services.books.BookNotFoundException;
import se.lexicon.library.services.books.NotUniqueException;

@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	BookManagementService bookService;

	@PostMapping("/create")
	public ResponseEntity<Book> create(@RequestBody Book book) throws NotUniqueException {

		return ResponseEntity.ok(bookService.createBook(book));

	}

	@PostMapping("/clone")
	public ResponseEntity<Optional<Book>> clone(@RequestBody Integer id) throws BookNotFoundException {
		return ResponseEntity.ok(Optional.of(bookService.cloneBook(id)));

	}

	@GetMapping("/findbytitle/{title}")
	public ResponseEntity<BooksWrapper> findByTitle(@PathVariable("title") String title) {

		BooksWrapper res;
		res = new BooksWrapper(bookService.searchForBooksByTitle(title));

		return ResponseEntity.ok(res);

	}

	// this one return copies of books with designated ISBN
	@GetMapping("/findbyisbn/{isbn}")
	public ResponseEntity<BooksWrapper> findByIsbn(@PathVariable("isbn") String isbn) {

		BooksWrapper res;
		res = new BooksWrapper(bookService.searchForBooksByIsbn(isbn));

		return ResponseEntity.ok(res);

	}

	// bookId is unique therefore one or zero books are returned.
	@GetMapping("/findbyid/{bookId}")
	public ResponseEntity<Optional<Book>> findById(@PathVariable("bookId") Integer bookId) throws BookNotFoundException {

		return ResponseEntity.ok(bookService.searchForBookById(bookId));


	}

	
	@GetMapping("/findbyauthor/{author}")
	public ResponseEntity<BooksWrapper> findByAuthor(@PathVariable("author") String author) throws BookNotFoundException {

		BooksWrapper res;
		res = new BooksWrapper(bookService.searchForBooksByAuthor(author));

		return ResponseEntity.ok(res);

	}
	
	@PostMapping("/findlike")
	public ResponseEntity<BooksWrapper> findLike(@RequestBody Book book) throws BookNotFoundException {

		BooksWrapper res;
		res = new BooksWrapper(bookService.searchForBooksLike(book));

		return ResponseEntity.ok(res);

	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<BooksWrapper> getAll() {
		BooksWrapper res;
		res = new BooksWrapper(bookService.getAll());

		return ResponseEntity.ok(res);

	}

	
	
	@PatchMapping("/update")
	public ResponseEntity<Book> update(@RequestBody Book book) throws BookNotFoundException {

		return ResponseEntity.ok(bookService.updateBook(book));

	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<Boolean> delete(@PathVariable("bookId") Integer bookId) {
		try {
			bookService.deleteBook(bookId);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(true);
	}

}
