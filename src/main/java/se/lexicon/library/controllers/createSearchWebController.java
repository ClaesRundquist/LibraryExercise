package se.lexicon.library.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import se.lexicon.library.domain.Book;

@Controller
public class createSearchWebController {

	@GetMapping("/createSearchForm")
	public String getForm(Model m) {
		Book book=new Book();
		book.setLoanPeriod(3L);
		m.addAttribute("book", book);
		return "bookCreate";
	}

}
