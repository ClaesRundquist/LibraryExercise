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
	private String isbn;
	private String title;
	private String author;
	private String genre;
	private String location;
	private Period loanPeriod;
	
	public Book() {
		super();
	}



	public Book(String isbn, String title, String author, String genre, String location, Period loanPeriod) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.location = location;
		this.loanPeriod = loanPeriod;
	}

	public Book(Book book) {
		super();
		this.isbn = book.isbn;
		this.title = book.title;
		this.author = book.author;
		this.genre = book.genre;
		this.location = book.location;
		this.loanPeriod = book.loanPeriod;
	}



	public Integer getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
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


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
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
		return "Book [id=" + id + ", ISBN=" + isbn + ", title=" + title + ", Author=" + author + ", Genre=" + genre
				+ ", location=" + location + ", loanPeriod=" + loanPeriod + "]";
	}



}
