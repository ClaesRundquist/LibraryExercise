package se.lexicon.library.domain;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne
	private Book book;
	private LocalDate lended;
	private Period loanPeriod;
	private Integer extendCount; // period may be extended n times.

	public Loan() {
		super();
	}

	public Loan(Book book, LocalDate lended, Period loanPeriod, Integer extendCount) {
		super();
		this.book = book;
		this.lended = lended;
		this.loanPeriod = loanPeriod;
		this.extendCount = extendCount;
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

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", book=" + book + ", lended=" + lended + ", loanPeriod=" + loanPeriod
				+ ", extendCount=" + extendCount + "]";
	}

	
}
