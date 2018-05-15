package se.lexicon.library.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import se.lexicon.library.restcontrollers.SimpleMember;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private LocalDate since;

	@OneToOne(cascade = CascadeType.ALL)
	private ContactInfo contactInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private LibraryCard libraryCard;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Loan> loans;

	// Needed by JPA
	public Member() {
		super();
	}

	public Member(String name, LocalDate since, ContactInfo contactInfo, LibraryCard libraryCard, List<Loan> loans) {
		super();
		this.name = name;
		this.since = since;
		this.contactInfo = contactInfo;
		this.libraryCard = libraryCard;
		this.loans = loans;
	}

	public Member(SimpleMember simpleMember) {
		this.name = simpleMember.getName();
		this.since = LocalDate.now();
		this.contactInfo = new ContactInfo(simpleMember.getAdress(), simpleMember.getPhone(), simpleMember.getEmail());
		this.libraryCard = null;
		this.loans = null;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}

	public Integer getId() {
		return id;
	}

	/*
	 * needed??? public void setId(Integer id) { this.id = id; }
	 */
	public LocalDate getSince() {
		return since;
	}

	public void setSince(LocalDate since) {
		this.since = since;
	}

	public LibraryCard getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", since=" + since + ", contactInfo=" + contactInfo
				+ ", libraryCard=" + libraryCard + ", loans=" + loans + "]";
	}

}
