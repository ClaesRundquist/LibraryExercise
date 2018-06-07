package se.lexicon.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		LoanWrapper loanWrap = new LoanWrapper();
		m.addAttribute("loanWrap", loanWrap);
		return "loanCreate";
	}

	@PostMapping("/createForm")
	public String fillCreateForm(LoanWrapper loanWrap, Model m) {
		try {
			Loan res = loanService.createLoan(loanWrap);
			m.addAttribute("loanWrap", new LoanWrapper());
			m.addAttribute("res", res);
		} catch (CreateLoanException e) {
			m.addAttribute("res", "Loan not created - " + e.getMessage());
		}

		return "loanCreate";
	}

	@GetMapping("/searchForm")
	public String getSearchForm(Model m) {
		LoanWrapper loanWrap = new LoanWrapper();
		m.addAttribute("loanWrap", loanWrap);
		return "loanSearch";
	}

	@GetMapping("/returnForm")
	public String getReturnForm(Model m) {
		m.addAttribute("bookId", new BookId(null));
		return "loanReturn";
	}

	@PostMapping("/returnForm")
	public String returnBook(BookId bookId, Model m) {
		String idInputClass="";
		try {
			loanService.returnBook(bookId.getValue());
			m.addAttribute("bookId", new BookId(null));
			m.addAttribute("res", "Book was returned, thank you!");
		} catch (LoanNotFoundException e) {
			m.addAttribute("res", "Loan not found - " + e.getMessage());
			idInputClass="notfound";
		}
		m.addAttribute("idInputClass", idInputClass);
		return "loanReturn";
	}
}
