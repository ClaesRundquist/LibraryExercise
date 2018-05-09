package se.lexicon.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LibraryCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	public LibraryCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

}
