/**
 * 
 */
package com.Casestudy.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Casestudy.DAOI.ClientDAOI;
import com.Casestudy.DAOI.ProjectDAOI.SQL;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Client;


/**
 * @author amahome
 *
 */
public class ClientDAO extends OracleConnection implements ClientDAOI{
	
	public List<Client> getAllClients(){
		List<Client> clientList = new ArrayList<Client>();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ALL_CLIENTS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				clientList.add(new Client(rs.getString(1), rs.getLong(2), rs.getLong(3),
						rs.getString(4), (Address) rs.getObject(5)));
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
		return clientList;
	}
	

	public boolean addClient(String clientFullName, Long clientHomePhone, Long clientMobile, String clientEmail) {
		boolean success = false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.CHECK_CLIENT_EXISTS.getQuery());
			ps.setString(1, clientFullName);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Client already exists!");
				success = false;
			}else {
				ps = connection.prepareStatement(SQL.ADD_CLIENT.getQuery());
				ps.setString(1, clientFullName);
				ps.setLong(2, clientHomePhone);
				ps.setLong(3, clientMobile);
				ps.setString(4, clientEmail);
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
	
	public boolean addClientAddress(String client, String homeAptno, String streetName, String city, String state, int zipcode) {
		boolean success = false;
		int maxId = 0;
		int relId = 0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ADDRESS_RELATION_ID.getQuery());
			ps.setString(1, client);
			rs = ps.executeQuery();
			if (rs.next()) {
				relId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_MAX_CLIENT_ID.getQuery());
			rs = ps.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.ADD_CLIENT_ADDRESS.getQuery());
			ps.setString(1, homeAptno);
			ps.setString(2, streetName);
			ps.setString(3, city);
			ps.setString(4, state);
			ps.setInt(5, zipcode);
			ps.setInt(6, maxId);
			ps.setInt(7, relId);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = connection.prepareStatement(SQL.UPDATE_CLIENT.getQuery());
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
