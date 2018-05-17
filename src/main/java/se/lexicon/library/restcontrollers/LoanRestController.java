package se.lexicon.library.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.Loan;
import se.lexicon.library.services.loans.LibraryCardNotFoundException;
import se.lexicon.library.services.loans.LoanManagementService;
import se.lexicon.library.services.loans.LoanWrapper;

@RestController
@RequestMapping("/loan")
public class LoanRestController {

	@Autowired
	LoanManagementService loanService;

	@PostMapping("/create")
	public ResponseEntity<Loan> createLoan(@RequestBody LoanWrapper loanWrap) {
		

		try {
			Loan res;
			res = loanService.createLoan(loanWrap);
			return ResponseEntity.ok(res);
		} catch (LibraryCardNotFoundException e) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		}

	}

	
	@GetMapping("/all")
	public ResponseEntity<LoansWrapper> getAll() {
		LoansWrapper res;
		res=new LoansWrapper(loanService.getAll());

		return ResponseEntity.ok(res);

	}

}
