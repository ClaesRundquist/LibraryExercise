package se.lexicon.library.restcontrollers;


import se.lexicon.library.domain.Book;
import se.lexicon.library.domain.Member;

public class SimpleLoan {
	
	private Book book;
	private Member member;

	public SimpleLoan() {
		super();
	}

	public SimpleLoan(Book book, Member member) {
		super();
		this.book = book;
		this.member = member;
	}


	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "SimpleLoan [book=" + book + ", member=" + member + "]";
	}
	
	
	
}
