package se.lexicon.library.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import se.lexicon.library.domain.Book;
import se.lexicon.library.services.books.BookManagementService;

@Controller
public class createSearchWebController {

	@Autowired
	BookManagementService bookService;

	// TODO: sessionwise
	UUID uuid = UUID.randomUUID();

	@GetMapping("/createSearchForm")
	public String getForm(Model m) {
		Book book = new Book();
		book.setLoanPeriod(3L);
		m.addAttribute("book", book);
		return "bookCreate";
	}

	@PostMapping("/createSearchForm")
	public String fillForm(Book book, Model m) throws NotUniqueException {

		Book res = bookService.createBook(book);
		m.addAttribute("book", new Book());

		return "bookCreate";
	}
}
