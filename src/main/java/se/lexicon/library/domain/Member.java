package se.lexicon.library.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Integer id;
	private LocalDate since;
	private ContactInfo contactInfo;
	private LibraryCard libraryCard;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Loan> loans;	

	// Needed by JPA
	public Member() {
		super();
	}

	public Member(LocalDate since, ContactInfo contactInfo, LibraryCard libraryCard, List<Loan> loans) {
		super();
		this.since = since;
		this.contactInfo = contactInfo;
		this.libraryCard = libraryCard;
		this.loans = loans;
	}

	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}

	public Integer getId() {
		return id;
	}

/* needed???
 * 	public void setId(Integer id) {
		this.id = id;
	}
*/
	public LocalDate getSince() {
		return since;
	}

	public void setSince(LocalDate since) {
		this.since = since;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
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
		return "Member [id=" + id + ", since=" + since + ", contactInfo=" + contactInfo + ", libraryCard=" + libraryCard
				+ ", loans=" + loans + "]";
	}
	
	
	
}
