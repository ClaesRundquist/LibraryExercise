package se.lexicon.library.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;
import se.lexicon.library.services.loans.CreateLoanException;
import se.lexicon.library.services.loans.LoanManagementService;
import se.lexicon.library.services.loans.LoanNotFoundException;
import se.lexicon.library.services.loans.LoanWrapper;
import se.lexicon.library.services.members.MemberManagementService;
import se.lexicon.library.services.members.MemberNotFoundException;

@RestController
@RequestMapping("/loan")
public class LoanRestController {

	@Autowired
	LoanManagementService loanService;
	@Autowired
	MemberManagementService memberService;

	@PostMapping("/create")
	public ResponseEntity<Loan> createLoan(@RequestBody LoanWrapper loanWrap) throws CreateLoanException {

		Loan res;
		res = loanService.createLoan(loanWrap);
		return ResponseEntity.ok(res);

	}

	@GetMapping("/findbybookid/{bookId}")
	public ResponseEntity<Loan> findByBookId(@PathVariable("bookId") Integer bookId) throws LoanNotFoundException {

		Loan res;
		res = loanService.searchForLoanByBookId(bookId).get();
		return ResponseEntity.ok(res);

	}

	@PutMapping("/returnbook/{bookId}")
	public ResponseEntity<Void> returnBook(@PathVariable("bookId") Integer bookId) throws LoanNotFoundException {

		loanService.returnBook(bookId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/findbymemberid/{memberId}")
	public ResponseEntity<LoansWrapper> findByMember(@PathVariable("memberId") Integer memberId) {

		LoansWrapper res;
		res = new LoansWrapper(loanService.searchForLoansByMember(memberId));
		return ResponseEntity.ok(res);

	}

	@GetMapping("/findbycardid/{libraryCardId}")
	public ResponseEntity<LoansWrapper> findByLibraryCardId(@PathVariable("libraryCardId") Integer libraryCardId)
			throws MemberNotFoundException {

		Member member;
		member = memberService.searchForMemberByLibraryCard(libraryCardId);
		LoansWrapper res;
		res = new LoansWrapper(loanService.searchForLoansByMember(member.getId()));

		return ResponseEntity.ok(res);

	}

	@GetMapping("/all")
	public ResponseEntity<LoansWrapper> getAll() {
		LoansWrapper res;
		res = new LoansWrapper(loanService.getAll());

		return ResponseEntity.ok(res);

	}

}
