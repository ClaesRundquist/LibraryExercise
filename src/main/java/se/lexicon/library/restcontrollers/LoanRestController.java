package se.lexicon.library.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.Loan;
import se.lexicon.library.services.loans.CreateLoanException;
import se.lexicon.library.services.loans.LoanManagementService;
import se.lexicon.library.services.loans.LoanNotFoundException;
import se.lexicon.library.services.loans.LoanWrapper;

@RestController
@RequestMapping("/loan")
public class LoanRestController {

	@Autowired
	LoanManagementService loanService;

	@PostMapping("/create")
	public ResponseEntity<?> createLoan(@RequestBody LoanWrapper loanWrap) {

		try {
			Loan res;
			res = loanService.createLoan(loanWrap);
			return ResponseEntity
		            .status(HttpStatus.CREATED)                 
		            .body(res);
		} catch (CreateLoanException e) {
			e.printStackTrace(); // see note 2
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	
	@GetMapping("/findbybookid/{bookId}")
		public ResponseEntity<Loan> findByBookId(@PathVariable("bookId") Integer bookId) {
			try {
				Loan res;
				res = loanService.searchForLoanByBookId(bookId).get();
				return ResponseEntity.ok(res);
			} catch (LoanNotFoundException e) {
				return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
			}

		}
	
	@GetMapping("/returnBook/{bookId}")
	public ResponseEntity<Void> returnBook(@PathVariable("bookId") Integer bookId) {
		try {
			loanService.returnBook(bookId);
			return new ResponseEntity<Void>( HttpStatus.OK );
		} catch (LoanNotFoundException e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/findbymemberid/{memberId}")
	public ResponseEntity<LoansWrapper> findByMember(@PathVariable("memberId") Integer memberId) {

		LoansWrapper res;
		res = new LoansWrapper(loanService.searchForLoansByMember(memberId));

		return ResponseEntity.ok(res);

	}
	
	
	@GetMapping("/all")
	public ResponseEntity<LoansWrapper> getAll() {
		LoansWrapper res;
		res = new LoansWrapper(loanService.getAll());

		return ResponseEntity.ok(res);

	}

}
