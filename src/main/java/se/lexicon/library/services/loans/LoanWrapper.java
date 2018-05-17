package se.lexicon.library.services.loans;

public class LoanWrapper {
	private Integer bookId;
	private Integer libraryCardId;

	
	
	public LoanWrapper() {
		super();
	}


	public LoanWrapper(Integer bookId, Integer memberId) {
		super();
		this.bookId = bookId;
		this.libraryCardId = memberId;
	}


	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public Integer getLibraryCardId() {
		return libraryCardId;
	}


	public void setLibraryCardId(Integer libraryCardId) {
		this.libraryCardId = libraryCardId;
	}


	@Override
	public String toString() {
		return "LoanWrapper [bookId=" + bookId + ", libraryCardId=" + libraryCardId + "]";
	}

	
	
	
}
