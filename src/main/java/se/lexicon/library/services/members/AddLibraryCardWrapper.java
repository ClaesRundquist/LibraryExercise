package se.lexicon.library.services.members;

public class AddLibraryCardWrapper {
	private Integer memberId;
	private Integer libraryCardId;

	public AddLibraryCardWrapper() {
		super();
	}

	public AddLibraryCardWrapper(Integer memberId, Integer libraryCardId) {
		super();
		this.memberId = memberId;
		this.libraryCardId = libraryCardId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getLibraryCardId() {
		return libraryCardId;
	}

	public void setLibraryCardId(Integer libraryCardId) {
		this.libraryCardId = libraryCardId;
	}

	@Override
	public String toString() {
		return "SetLibraryCardWrapper [memberId=" + memberId + ", libraryCardId=" + libraryCardId + "]";
	}
	
	
	
}
