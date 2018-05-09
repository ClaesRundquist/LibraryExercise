package se.lexicon.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class ContactInfo {
	// TODO  now mock
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String phone;

	
	public ContactInfo() {
		super();
	}


	public ContactInfo(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getId() {
		return id;
	}


	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
	
}
