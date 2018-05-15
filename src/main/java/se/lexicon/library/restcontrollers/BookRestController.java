package se.lexicon.library.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.services.members.MemberManagementService;

@RestController
@RequestMapping("/member")
public class BookRestController {

		@Autowired
		BookManagementService BookService;

		@PostMapping("/create")

		
		
		
}
