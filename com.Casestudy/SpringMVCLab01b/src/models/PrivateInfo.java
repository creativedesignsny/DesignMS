package models;

import java.util.Date;

public class PrivateInfo {

	private Long ssn;
	private Long ccn;
	private Date dob;
	
	public void setSSN(Long ssn) {
		this.ssn = ssn;
	}
	
	public void setCCN(Long ccn) {
		this.ccn = ccn;
	}
	
	public void setDOB(Date dob) {
		this.dob = dob;
	}
	
	public Long getSSN() {
		return ssn;
	}
	
	public Long getCCN() {
		return ccn;
	}
	
	public Date getDOB() {
		return dob;
	}
}
