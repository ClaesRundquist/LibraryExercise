package se.lexicon.library.restcontrollers;

import java.time.LocalDate;

import se.lexicon.library.domain.Member;


public class MemberDTO {
	private Integer id;
	private String name;
	private LocalDate since;
	private String adress;
	private String phone;
	private String email;	
	private Integer libraryCardId;

	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(Member member) {
		super();

		this.id = member.getId();
		this.name = member.getName();
		this.since = member.getSince();
		this.adress = member.getContactInfo().getAdress();
		this.phone = member.getContactInfo().getPhone();
		this.email = member.getContactInfo().getEmail();
		if (null !=member.getLibraryCard()) {
			this.libraryCardId = member.getLibraryCard().getId();	
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getSince() {
		return since;
	}
	public void setSince(LocalDate since) {
		this.since = since;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getLibraryCardId() {
		return libraryCardId;
	}
	public void setLibraryCardId(Integer libraryCardId) {
		this.libraryCardId = libraryCardId;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + ", since=" + since + ", adress=" + adress + ", phone=" + phone
				+ ", email=" + email + ", libraryCardId=" + libraryCardId + "]";
	}

	

}
