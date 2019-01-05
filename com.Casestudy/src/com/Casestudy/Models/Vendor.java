/**
 * 
 */
package com.Casestudy.Models;

/**
 * @author amahome
 *Model class for Vendor
 */
public class Vendor {
	
	private int vendorId;
	private String vendorFullName;
	private Long vendorHomePhone;
	private Long vendorMobile;
	private String vendorEmail;
	private Address vendorAddress;
	/**
	 * @param vendorId
	 * @param vendorFullName
	 * @param vendorHomePhone
	 * @param vendorMobile
	 * @param vendorEmail
	 * @param vendorAddress
	 * Constructor with all params
	 */
	public Vendor(int vendorId, String vendorFullName, Long vendorHomePhone, Long vendorMobile, String vendorEmail,
			Address vendorAddress) {
		//super();
		this.vendorId = vendorId;
		this.vendorFullName = vendorFullName;
		this.vendorHomePhone = vendorHomePhone;
		this.vendorMobile = vendorMobile;
		this.vendorEmail = vendorEmail;
		this.vendorAddress = vendorAddress;
	}
	
	/**empty constructor**/
	public Vendor() {
		
	}

	/**
	 * @return the vendorId
	 */
	public int getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the vendorFullName
	 */
	public String getVendorFullName() {
		return vendorFullName;
	}

	/**
	 * @param vendorFullName the vendorFullName to set
	 */
	public void setVendorFullName(String vendorFullName) {
		this.vendorFullName = vendorFullName;
	}

	/**
	 * @return the vendorHomePhone
	 */
	public Long getVendorHomePhone() {
		return vendorHomePhone;
	}

	/**
	 * @param vendorHomePhone the vendorHomePhone to set
	 */
	public void setVendorHomePhone(Long vendorHomePhone) {
		this.vendorHomePhone = vendorHomePhone;
	}

	/**
	 * @return the vendorMobile
	 */
	public Long getVendorMobile() {
		return vendorMobile;
	}

	/**
	 * @param vendorMobile the vendorMobile to set
	 */
	public void setVendorMobile(Long vendorMobile) {
		this.vendorMobile = vendorMobile;
	}

	/**
	 * @return the vendorEmail
	 */
	public String getVendorEmail() {
		return vendorEmail;
	}

	/**
	 * @param vendorEmail the vendorEmail to set
	 */
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	/**
	 * @return the vendorAddress
	 */
	public Address getVendorAddress() {
		return vendorAddress;
	}

	/**
	 * @param vendorAddress the vendorAddress to set
	 */
	public void setVendorAddress(Address vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	
	
}
