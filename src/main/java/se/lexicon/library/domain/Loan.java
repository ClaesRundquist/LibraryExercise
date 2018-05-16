package se.lexicon.library.domain;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import se.lexicon.library.restcontrollers.SimpleLoan;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Book book;
	private LocalDate lended;
	private Period loanPeriod;
	private Integer extendCount; // period may be extended n times.

	@ManyToOne
	private Member member;
	
	public Loan() {
		super();
	}


	
	public Loan(Book book, LocalDate lended, Period loanPeriod, Integer extendCount, Member member) {
		super();
		this.book = book;
		this.lended = lended;
		this.loanPeriod = loanPeriod;
		this.extendCount = extendCount;
		this.member = member;
	}



	public Loan(SimpleLoan simpleLoan) {
		super();
		this.book = simpleLoan.getBook();
		this.lended = LocalDate.now();
		this.loanPeriod = this.book.getLoanPeriod();
		this.extendCount = 0;
		this.member = simpleLoan.getMember();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getLended() {
		return lended;
	}

	public void setLended(LocalDate lended) {
		this.lended = lended;
	}

	public Period getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(Period loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public Integer getExtendCount() {
		return extendCount;
	}

	public void setExtendCount(Integer extendCount) {
		this.extendCount = extendCount;
	}

	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", book=" + book + ", lended=" + lended + ", loanPeriod=" + loanPeriod
				+ ", extendCount=" + extendCount + ", member=" + member + "]";
	}



	
}
