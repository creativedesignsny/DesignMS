/**
 * 
 */
package com.Casestudy.DAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import com.Casestudy.DAOI.ProfileDAOI;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Profile;

/**
 * @author amahome
 *
 */
public class ProfileDAO extends OracleConnection implements ProfileDAOI{
	
	public Profile getEmpProfileByEmail(String email) {
		final int BUFFER_SIZE = 4096;
		Profile profile = new Profile();
		Address address = new Address();
		String filePath = "C:/Users/amahome/eclipse-workspace2/com.Casestudy/WebContent/resources/images/emp_img.png";
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_EMP_PROFILE_BY_EMAIL.getQuery());
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				profile.setEmpId(rs.getInt(1));
				profile.setFullName(rs.getString(2));
				profile.setDob(rs.getString(3));
				profile.setEmpHomePhone(rs.getString(4));
				profile.setEmpMobilePhone(rs.getString(5));
				profile.setEmpAddress(address);
				profile.setEmpEmail(rs.getString(11));
				address.setHomeAptno(rs.getString(6));
				address.setStreetName(rs.getString(7));
				address.setCity(rs.getString(8));
				address.setState(rs.getString(9));
				address.setZipcode(rs.getInt(10));
				Blob b=rs.getBlob(12);
		        long blobLength = b.length();

		        // Get bytes from the BLOB in a byte array
		        int pos = 1;   // position is 1-based
		        int len = 10;
		        byte[] bytes = b.getBytes(pos, len);

		        // Get bytes from the BLOB using a stream
		        InputStream is = b.getBinaryStream();
		        int img = is.read();
  
	            return profile;
			}
			System.out.println("ok");  
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return null;
	}

}
