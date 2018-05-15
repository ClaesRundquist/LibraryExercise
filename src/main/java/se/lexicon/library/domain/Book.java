package se.lexicon.library.domain;

import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private String ISBN;
	private String title;
	private String author;
	private String gengre;
	private String location;
	private Period loanPeriod;
	
	public Book() {
		super();
	}



	public Book(String iSBN, String title, String author, String gengre, String location, Period loanPeriod) {
		super();
		this.ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.gengre = gengre;
		this.location = location;
		this.loanPeriod = loanPeriod;
	}



	public Integer getId() {
		return id;
	}

	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getGengre() {
		return gengre;
	}


	public void setGengre(String gengre) {
		this.gengre = gengre;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	

	public Period getLoanPeriod() {
		return loanPeriod;
	}



	public void setLoanPeriod(Period loanPeriod) {
		this.loanPeriod = loanPeriod;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN=" + ISBN + ", title=" + title + ", Author=" + author + ", Gengre=" + gengre
				+ ", location=" + location + ", loanPeriod=" + loanPeriod + "]";
	}



}
