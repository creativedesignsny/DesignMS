/**
 * 
 */
package com.Casestudy.DAOI;

import com.Casestudy.Models.Profile;

/**
 * @author amahome
 *
 */
public interface ProfileDAOI {
	
	enum SQL {
		
		/** Gets the details of the employee for the given email **/
		GET_EMP_PROFILE_BY_EMAIL("SELECT EMPID, fullName, TO_CHAR(dob,'MM/DD/YYYY'),\r\n" +
				"				TO_CHAR(EMPHOMEPHONE, '000g000g0000','nls_numeric_characters=.-'), TO_CHAR(EMPMOBILE, '000g000g0000','nls_numeric_characters=.-'),\r\n" +
				"				address.homeAptno, address.streetName, address.city,\r\n" + 
				"				address.state, address.ZIPCODE, empEmail, EMPIMG FROM EMPLOYEE\r\n" +
				"				JOIN address ON employee.EMPADDRESSID = address.ADDRESSID\r\n" +
				"				WHERE empEmail = ?");
		private final String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	
	
	/** method to get the employee detail
	 * @param email
	 * 
	 * return type - Profile
	 * **/
	public Profile getEmpProfileByEmail(String email);

}
