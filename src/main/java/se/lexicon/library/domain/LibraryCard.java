package se.lexicon.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LibraryCard {
	@Id
	//card id printed on card, not auto generated.
	Integer id;

	public LibraryCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibraryCard(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
