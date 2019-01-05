/**
 * 
 */
package com.Casestudy.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Casestudy.DAOI.VendorDAOI;
import com.Casestudy.DAOI.ClientDAOI.SQL;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Vendor;

/**
 * @author amahome
 *
 */
public class VendorDAO extends OracleConnection implements VendorDAOI{
	
	public List<Vendor> getAllVendors(){
		List<Vendor> vendorList = new ArrayList<Vendor>();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ALL_VENDORS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				vendorList.add(new Vendor(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getLong(4),
						rs.getString(5), (Address) rs.getObject(6)));
			}
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
		return vendorList;
	}
	

	public boolean addVendor(String vendorFullName, Long vendorHomePhone, Long vendorMobile, String vendorEmail) {
		boolean success = false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.CHECK_VENDOR_EXISTS.getQuery());
			ps.setString(1, vendorFullName);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Vendor already exists!");
				success = false;
			}else {
				ps = connection.prepareStatement(SQL.ADD_VENDOR.getQuery());
				ps.setString(1, vendorFullName);
				ps.setLong(2, vendorHomePhone);
				ps.setLong(3, vendorMobile);
				ps.setString(4, vendorEmail);
				rs = ps.executeQuery();
				if (rs.next()) {
					success = true;
				}
			}
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
		return success;
	}
	
	public boolean addVendorAddress(String vendor, String homeAptno, String streetName, String city, String state, int zipcode) {
		boolean success = false;
		int maxId = 0;
		int relId = 0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ADDRESS_RELATION_ID.getQuery());
			ps.setString(1, vendor);
			rs = ps.executeQuery();
			if (rs.next()) {
				relId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_MAX_VENDOR_ID.getQuery());
			rs = ps.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.ADD_VENDOR_ADDRESS.getQuery());
			ps.setString(1, homeAptno);
			ps.setString(2, streetName);
			ps.setString(3, city);
			ps.setString(4, state);
			ps.setInt(5, zipcode);
			ps.setInt(6, maxId);
			ps.setInt(7, relId);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = connection.prepareStatement(SQL.UPDATE_VENDOR.getQuery());
				ps.setInt(1, maxId);
				rs = ps.executeQuery();
				if (rs.next()) {
					success = true;
				}
			}
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
		return success;
			
	}
	

}
