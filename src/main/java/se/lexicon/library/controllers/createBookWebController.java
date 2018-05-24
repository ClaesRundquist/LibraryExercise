package se.lexicon.library.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import se.lexicon.library.domain.Book;
import se.lexicon.library.services.books.BookManagementService;
import se.lexicon.library.services.books.BookNotFoundException;
import se.lexicon.library.services.books.NotUniqueException;

@Controller
public class createBookWebController {

	@Autowired
	BookManagementService bookService;


	@GetMapping("/createForm")
	public String getCreateForm(Model m) {
		Book book = new Book();
		m.addAttribute("book", book);
		return "bookCreate";
	}

	@PostMapping("/createForm")
	public String fillCreateForm(Book book, Model m) throws NotUniqueException {

		Book res = bookService.createBook(book);
		m.addAttribute("book", new Book());
		m.addAttribute("res", res);
		
		return "bookCreate";
	}

	@GetMapping("/findByISBNResults/{isbn}")
	public String getByISBNForm(@PathVariable("isbn") String isbn, Model m) {
		List<Book> books = bookService.searchForBooksByIsbn(isbn);
		m.addAttribute("bookList", books);
		return "bookFindResults";
	}

	@DeleteMapping("/delete/{id}")
	public String getDelete(@PathVariable("id") Integer id, Model m) {
		Book book = new Book();
		bookService.deleteBook(id);
		m.addAttribute("book", book);
		// TODO  redirect to appropriate page
		return "bookCreate";
	}
	@PostMapping("/clone/{id}")
	public String fillClone(@PathVariable("id") Integer id, Model m) throws BookNotFoundException {
		Book book = bookService.cloneBook(id);
		m.addAttribute("book", book);
		// TODO  redirect to appropriate page
		return "bookCreate";
	}
}
