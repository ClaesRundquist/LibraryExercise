package se.lexicon.library.services.loans;

import java.time.LocalDate;
import java.util.List;

import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;

public interface LoanManagementService {
	// return Loan to make receipt printout possible.
	public Loan createLoan(Integer libraryCardId, Integer bookId);

	public Loan searchForLoanById(String loanId) throws LoanNotFoundException;

	public List<Loan> searchForLoansByMember(Member member);

	public List<Loan> searchForLoansByLibraryCard(Integer libraryCardId);

	public List<Loan> searchForLoansByDueDate(LocalDate dueDate);

	public void deleteLoan(String loanId) throws LoanNotFoundException;

	// public Loan extendLoan(Loan loan) throws LoanNotFoundException;

	/*
	 * private Integer id;
	 * 
	 * @OneToOne private Book book; private LocalDate lended; private Period
	 * loanPeriod; private Integer extendCount; // period may be extended n times.
	 * 
	 */
}
