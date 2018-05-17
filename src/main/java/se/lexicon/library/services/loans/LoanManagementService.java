package se.lexicon.library.services.loans;

import java.time.LocalDate;
import java.util.List;

import se.lexicon.library.domain.Loan;

public interface LoanManagementService {
	public Loan createLoan(LoanWrapper loanWrap) throws LibraryCardNotFoundException;

	public List<Loan> getAll();
	
	public Loan searchForLoanById(String loanId) throws LoanNotFoundException;

	public List<Loan> searchForLoansByMember(Integer memberId);

	public List<Loan> searchForLoansByLibraryCard(Integer libraryCardId);

	public List<Loan> searchForLoansByDueDate(LocalDate dueDate);

	public void deleteLoan(String loanId) throws LoanNotFoundException;

	// public Loan extendLoan(Loan loan) throws LoanNotFoundException;

}
