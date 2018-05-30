package se.lexicon.library.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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


	@GetMapping("/searchForm")
	public String getSearchForm(Model m) {
		Book book = new Book();
		m.addAttribute("book", book);
		return "bookSearch";
	}

	
	@GetMapping("/findByISBNResults/{isbn}")
	public String getByISBNForm(@PathVariable("isbn") String isbn, Model m) {
		List<Book> books = bookService.searchForBooksByIsbn(isbn);
		m.addAttribute("bookList", books);
		return "bookFindResults";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model m) {
		Book book = new Book();
		bookService.deleteBook(id);
		m.addAttribute("book", book);
		// TODO  redirect to appropriate page
		return "bookSearch";
	}

	@GetMapping("/findToUpdate/{id}")
	public String getUpdateForm(@PathVariable("id") Integer id, Model m) throws BookNotFoundException {
		Optional<Book> book=bookService.searchForBookById(id);
		if (!book.isPresent()) {
			// concurrent deletes may cause this to happen, even though id is generated from database.
			throw new BookNotFoundException("Book not found, deleted by another user?");
		}
		m.addAttribute("book", book.get());
		return "bookUpdate";
	}

	@PatchMapping("/updateForm")
	public String fillUpdateForm(Book book, Model m) throws BookNotFoundException {

		Book res = bookService.updateBook(book);
		m.addAttribute("book", res);
		// TODO  maybe we should not return a result as ....
		return "bookUpdate";
	}

	
	@PostMapping("/clone/{id}")
	public String fillClone(@PathVariable("id") Integer id, Model m) throws BookNotFoundException {
		Book book = bookService.cloneBook(id);
		m.addAttribute("book", book);
		// TODO  redirect to appropriate page
		return "bookCreate";
	}
}
