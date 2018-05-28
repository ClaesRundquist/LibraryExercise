package se.lexicon.library.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LibraryCard {
	@Id
	// card id printed on card, not auto generated.
	private Integer id;
	private LocalDate issued;
	private Long period = 3L; // Valid 3 years.

	@OneToOne
	@JsonManagedReference
	private Member member;

	public LibraryCard() {
		super();
	}

	public LibraryCard(Integer libraryCardId, Member member) {
		super();
		this.id = libraryCardId;
		this.issued = LocalDate.now();
		this.member = member;
	}

	
	public Integer getId() {
		return id;
	}


	@JsonGetter("isvalid")
	public boolean isValid() {
		return !LocalDate.now().isAfter((issued.plusYears(period)));
	}

	@JsonGetter("member")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "LibraryCard [id=" + id + ", issued=" + issued + ", period=" + period + ", member=" + member + "]";
	}

	
}
