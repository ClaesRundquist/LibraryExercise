package se.lexicon.library.restcontrollers;


import se.lexicon.library.domain.ContactInfo;

public class SimpleMember {
	private String name;
	private String adress;
	private String phone;
	private String email;
	
	public SimpleMember() {
		super();
	}

	public SimpleMember(String name, String adress, String phone, String email) {
		super();
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "SimpleMember [name=" + name + ", adress=" + adress + ", phone=" + phone + ", email=" + email + "]";
	}


	
	
}
