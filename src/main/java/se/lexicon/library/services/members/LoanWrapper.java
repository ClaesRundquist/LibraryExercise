package se.lexicon.library.services.members;

public class LoanWrapper {
	private Integer bookId;
	private Integer memberId;

	
	
	public LoanWrapper() {
		super();
	}


	public LoanWrapper(Integer bookId, Integer memberId) {
		super();
		this.bookId = bookId;
		this.memberId = memberId;
	}


	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "LoanWrapper [bookId=" + bookId + ", memberId=" + memberId + "]";
	}
	
	
	
}
