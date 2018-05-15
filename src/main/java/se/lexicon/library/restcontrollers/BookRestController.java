package se.lexicon.library.restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.Book;
import se.lexicon.library.services.books.BookManagementService;

@RestController
@RequestMapping("/book")
public class BookRestController {

		@Autowired
		BookManagementService bookService;

		@PostMapping("/create")
		public ResponseEntity<Book> create(@RequestBody Book book) {

			return ResponseEntity.ok(bookService.createBook(book));

		}

		
		
		
}
