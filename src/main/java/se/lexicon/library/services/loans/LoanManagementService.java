package se.lexicon.library.services.loans;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import se.lexicon.library.domain.Loan;

public interface LoanManagementService {
	public Loan createLoan(LoanWrapper loanWrap) throws CreateLoanException;

	public List<Loan> getAll();
	
	public Optional<Loan> searchForLoanByBookId(Integer bookId) throws LoanNotFoundException;

	public List<Loan> searchForLoansByMember(Integer memberId);

	public List<Loan> searchForLoansByLibraryCard(Integer libraryCardId) throws LoanNotFoundException;

	public List<Loan> searchForLoansByDueDate(LocalDate dueDate);

	public void returnBook(Integer bookId) throws LoanNotFoundException;

	// public Loan extendLoan(Loan loan) throws LoanNotFoundException;

}

