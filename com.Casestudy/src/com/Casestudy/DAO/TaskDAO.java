/**
 * 
 */
package com.Casestudy.DAO;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Casestudy.DAOI.TaskDAOI;
import com.Casestudy.DAOI.ProjectDAOI.SQL;
import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Project;
import com.Casestudy.Models.Task;

/**
 * @author amahome
 *
 */
public class TaskDAO extends OracleConnection implements TaskDAOI{
	
	public boolean addTask(String taskName, String assignToEmp, String assignByEmp, String assignDate, String dueDate, String comments, String note, String prName) {
		boolean success = false;
		int assignToId = 0;
		int assignById = 0;
		int prId = 0;
		try {
			connection = getConnection();
			
			ps = connection.prepareStatement(SQL.GET_EMP_ID.getQuery());
			ps.setString(1, assignToEmp);
			rs = ps.executeQuery();
			if (rs.next()) {
				assignToId = rs.getInt(1);
				System.out.println(assignToId);
			}
			ps = connection.prepareStatement(SQL.GET_EMP_ID.getQuery());
			ps.setString(1, assignByEmp);
			rs = ps.executeQuery();
			if (rs.next()) {
				assignById = rs.getInt(1);
				System.out.println(assignById);
			}
			
			ps = connection.prepareStatement(SQL.GET_PROJECT_BY_ID.getQuery());
			ps.setString(1, prName);
			rs = ps.executeQuery();
			if (rs.next()) {
				prId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.ADD_TASK.getQuery());
			ps.setString(1, taskName);
			ps.setInt(2, assignToId);
			ps.setInt(3, assignById);
			ps.setString(4, assignDate);
			ps.setString(5, dueDate);
			ps.setString(6, comments);
			ps.setString(7, note);
			ps.setInt(8, prId);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
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
	
	
	public List<Task> getAllTasks(){
		List<Task> taskList = new ArrayList<Task>();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ALL_TASKS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				taskList.add(new Task(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
		return taskList;
	}
	
	public List<Task> getTaskByEmployee(int empId){
		List<Task> taskListByEmp = new ArrayList<Task>();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_TASK_BY_EMPLOYEE.getQuery());
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			while (rs.next()) {
				taskListByEmp.add(new Task(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
		return taskListByEmp;
	}
	
	public boolean updateTask(String assignToEmp, String assignByEmp, String assignDate, String dueDate, String finishDate, String comments, String note, String prName, String taskName) {
		boolean success = false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.UPDATE_TASK.getQuery());
			ps.setString(1, assignToEmp);
			ps.setString(2, assignByEmp);
			ps.setString(3, assignDate);
			ps.setString(4, dueDate);
			ps.setString(5, finishDate);
			ps.setString(6, comments);
			ps.setString(7, note);
			ps.setString(8, prName);
			ps.setString(9, taskName);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
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
	
	
	public Task getTaskByName(String taskName) {
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_TASK_BY_NAME.getQuery());
			ps.setString(1, taskName);
			rs = ps.executeQuery();
			if (rs.next()) {
				Task task = new Task(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
	            return task;
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
		return null;
	}
}
