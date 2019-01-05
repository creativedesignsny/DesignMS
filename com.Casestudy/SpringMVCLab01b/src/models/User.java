package models;

public class User {

	private String fname;
	private String lname;
	private String uname;
	private String gender;
	private ContactInfo contactInfo;
	private PrivateInfo privateInfo;
	
	public User() {
		fname = "";
		lname = "";
		uname = "";
		gender = "";
		contactInfo = null;
		privateInfo = null;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public void setPrivateInfo(PrivateInfo privateInfo) {
		this.privateInfo = privateInfo;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public String getUname() {
		return uname;
	}
	
	public String getGender() {
		return gender;
	}
	
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	
	public PrivateInfo getPrivateInfo() {
		return privateInfo;
	}
}
