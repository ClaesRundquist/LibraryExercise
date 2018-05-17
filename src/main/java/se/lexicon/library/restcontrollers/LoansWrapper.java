package se.lexicon.library.restcontrollers;

import java.util.List;

import se.lexicon.library.domain.Loan;

public class LoansWrapper {
	List<Loan> loans;

	public LoansWrapper() {
		super();
	}

	public LoansWrapper(List<Loan> loans) {
		super();
		this.loans = loans;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "LoansWrapper [loans=" + loans + "]";
	}
	
	
}
