package se.lexicon.library.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import se.lexicon.library.restcontrollers.SimpleLoan;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Book book;
	private LocalDate dueDate;
	private Long loanPeriod; // number of days.
	private Integer extendCount; // period may be extended n times.

	@ManyToOne
	@JsonManagedReference
	private Member member;
	
	public Loan() {
		super();
	}


	
	public Loan(Book book, LocalDate dueDate, Long loanPeriod, Integer extendCount, Member member) {
		super();
		this.book = book;
		this.dueDate = dueDate;
		this.loanPeriod = loanPeriod;
		this.extendCount = extendCount;
		this.member = member;
	}



	public Loan(SimpleLoan simpleLoan) {
		super();
		this.book = simpleLoan.getBook();
		this.loanPeriod = this.book.getLoanPeriod();
		this.dueDate = LocalDate.now().plusDays(this.getLoanPeriod());
		this.extendCount = 0;
		this.member = simpleLoan.getMember();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}



	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public Long getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(Long loanPeriod) {
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
		return "Loan [id=" + id + ", book=" + book + ", dueDate=" + dueDate + ", loanPeriod=" + loanPeriod
				+ ", extendCount=" + extendCount + ", member=" + member + "]";
	}



}
