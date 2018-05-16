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

@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	BookManagementService bookService;

	@PostMapping("/create")
	public ResponseEntity<Book> create(@RequestBody Book book) {

		return ResponseEntity.ok(bookService.createBook(book));

	}

	@PostMapping("/clone")
	public ResponseEntity<Optional<Book>> clone(@RequestBody String isbn) {
		try {
			return ResponseEntity.ok(Optional.of(bookService.cloneBook(isbn)));
		} catch (BookNotFoundException e) {
			return new ResponseEntity<Optional<Book>>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/findbytitle/{title}")
	public ResponseEntity<BookCollection> findByTitle(@PathVariable("title") String title) {

		BookCollection res;
		res = new BookCollection(bookService.searchForBooksByTitle(title));

		return ResponseEntity.ok(res);

	}

	@GetMapping("/findbyisbn/{isbn}")
	public ResponseEntity<BookCollection> findByIsbn(@PathVariable("isbn") String isbn) {

		BookCollection res;
		res = new BookCollection(bookService.searchForBooksByIsbn(isbn));

		return ResponseEntity.ok(res);

	}

	@GetMapping("/findbyid/{bookId}")
	public ResponseEntity<Optional<Book>> findById(@PathVariable("bookId") String bookId) {

		Optional<Book> res;
		try {
			res = bookService.searchForBookById(Integer.valueOf(bookId));
		} catch (BookNotFoundException e) {
			return new ResponseEntity<Optional<Book>>(HttpStatus.BAD_REQUEST);
		}

		if (res.isPresent() == true) {
			return ResponseEntity.ok(res);

		} else {
			return new ResponseEntity<Optional<Book>>(HttpStatus.NOT_FOUND);
		}

	}

	@PatchMapping("/update")
	public ResponseEntity<Book> update(@RequestBody Book book) {

		try {
			return ResponseEntity.ok(bookService.updateBook(book));
		} catch (BookNotFoundException e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

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
