package se.lexicon.library.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LibraryCard {
	@Id
	//card id printed on card, not auto generated.
	private Integer id;
	private LocalDate issued;
	private Long period=3L; // Valid 3 years.

	@OneToOne
//	@JsonManagedReference
	private Member member;
	

	public LibraryCard() {
		super();
	}

	public LibraryCard(Integer id) {
		super();
		this.id = id;
		this.issued=LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public boolean isValid() {
		return !LocalDate.now().isAfter((issued.plusYears(period)));
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
