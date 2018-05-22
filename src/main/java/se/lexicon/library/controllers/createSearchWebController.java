package se.lexicon.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import se.lexicon.library.domain.Member;

@Controller
public class createSearchWebController {

	@GetMapping("/createSearchForm")
	public String getForm(Model m) {
		m.addAttribute("Member", new Member());
		return "bookCreate";
	}

}
