package se.lexicon.library.services.loans;

public class LoanNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2096336118924101020L;

	public LoanNotFoundException(String message) {
		super(message);
	}
}
