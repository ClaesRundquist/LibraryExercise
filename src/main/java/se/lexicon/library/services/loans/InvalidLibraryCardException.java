package se.lexicon.library.services.loans;

public class InvalidLibraryCardException extends CreateLoanException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2506094863921771422L;

	public InvalidLibraryCardException(String message) {
		super(message);
	}
}
