package se.lexicon.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String adress;
	private String phone;
	private String email;


	
	public ContactInfo() {
		super();
	}



	public ContactInfo(String adress, String phone, String email) {
		super();
		this.adress = adress;
		this.phone = phone;
		this.email = email;
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



	public Integer getId() {
		return id;
	}



	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", adress=" + adress + ", phone=" + phone + ", email=" + email + "]";
	}	
	
}
