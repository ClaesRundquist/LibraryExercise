package se.lexicon.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import se.lexicon.library.domain.Loan;
import se.lexicon.library.services.loans.CreateLoanException;
import se.lexicon.library.services.loans.LoanManagementService;
import se.lexicon.library.services.loans.LoanNotFoundException;
import se.lexicon.library.services.loans.LoanWrapper;

	@Controller
	@RequestMapping("/loan")
	public class LoanWebController {

		@Autowired
		LoanManagementService loanService;
		
		@GetMapping("/createForm")
		public String getCreateForm(Model m) {
			LoanWrapper  loanWrap = new LoanWrapper();
			m.addAttribute("loanWrap", loanWrap);
			return "loanCreate";
		}

		@PostMapping("/createForm")
		public String fillCreateForm(LoanWrapper loanWrap, Model m) throws CreateLoanException {

			Loan res = loanService.createLoan(loanWrap);
			m.addAttribute("loanWrap", new LoanWrapper());
			m.addAttribute("res", res);
			
			return "loanCreate";
		}

		@GetMapping("/searchForm")
		public String getSearchForm(Model m) {
			LoanWrapper loanWrap = new LoanWrapper();
			m.addAttribute("loanWrap", loanWrap);
			return "loanSearch";
		}

		
		// TODO return form, html and those :
		@GetMapping("/returnForm")
		public String getReturnForm(Model m) {
			return "loanReturn";
		}

		@PutMapping("/returnForm/{bookId}")
		public String returnBook(@PathVariable("bookId") Integer bookId, Model m) throws LoanNotFoundException {

			loanService.returnBook(bookId);
			m.addAttribute("res", "Book was returned, thank you!");
			return "loanReturn";
		}
}
