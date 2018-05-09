package se.lexicon.library.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private String ISBN;
	private String title;
	private String Author;
	private String Gengre;
	@OneToOne(cascade=CascadeType.ALL)
	private Location location;

	
	public Book() {
		super();
	}


	public Book(Integer id, String iSBN, String title, String author, String gengre, Location location) {
		super();
		this.id = id;
		ISBN = iSBN;
		this.title = title;
		Author = author;
		Gengre = gengre;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public String getGengre() {
		return Gengre;
	}


	public void setGengre(String gengre) {
		Gengre = gengre;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN=" + ISBN + ", title=" + title + ", Author=" + Author + ", Gengre=" + Gengre
				+ ", location=" + location + "]";
	}



	
}
