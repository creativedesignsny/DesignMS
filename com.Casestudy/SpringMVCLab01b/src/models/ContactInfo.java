package models;

public class ContactInfo {

	private Long phoneNumber;
	private String email;
	private String linkedInUrl;
	
	public void setPhone(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setLinkedIn(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Long getPhone() {
		return phoneNumber;
	}
	
	public String getLinkedIn() {
		return linkedInUrl;
	}
}
