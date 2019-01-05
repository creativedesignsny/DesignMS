/**
 * 
 */
package com.Casestudy.Controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.DAO.ProjectDAO;
import com.Casestudy.DAO.TaskDAO;
import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Project;
import com.Casestudy.Models.Task;

/**
 * @author amahome
 *
 */

@Controller
@RequestMapping("/")
@SessionAttributes("tasks")
public class TaskController {
	
//	@RequestMapping(value = "/forgot-password", method=RequestMethod.GET)
//	public ModelAndView displayHomePage() {
//		ModelAndView mav = new ModelAndView("editTask");
//		TaskDAO taskDAO = new TaskDAO();
//		List<Task> taskList = new ArrayList<Task>();
//		EmployeeDAO empDAO = new EmployeeDAO();
//		List<Employee> empList = new ArrayList<Employee>();
//		empList = empDAO.getAllEmployee();
//		taskList = taskDAO.getAllTasks();
//		mav.addObject("listEmp", empList);
//		mav.addObject("listTask", taskList);
//		return mav;
//	}
	
	
	@RequestMapping(value = "/Task", method=RequestMethod.GET)
	public ModelAndView displayTask() {
		List<Task> taskList = new ArrayList<Task>();
		TaskDAO taskDAO = new TaskDAO();
		taskList = taskDAO.getAllTasks();
		ModelAndView mav = new ModelAndView("Task");
		mav.addObject("listTask", taskList);
		return mav;
	}
	
	@RequestMapping(value = "/addTask", method=RequestMethod.GET)
	public ModelAndView displayAddTask() {
		ModelAndView mav = new ModelAndView("addTask");
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getAllEmployee();
		mav.addObject("listEmp", empList);
		return mav;
	}
	
	@RequestMapping(value = "/ajax-task", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Task getTask(@RequestParam("taskName") String taskname, HttpSession request) {
		Task editTask = new Task();
		TaskDAO taskDAO = new TaskDAO();
		editTask = taskDAO.getTaskByName(taskname);
		return editTask;
	}
	
	
	@RequestMapping(value = "/editTask", method=RequestMethod.GET)
	public ModelAndView displayEditTask(@ModelAttribute("task") Task task, BindingResult errors) {
		ModelAndView mav = new ModelAndView("editTask");
		TaskDAO taskDAO = new TaskDAO();
		List<Task> taskList = new ArrayList<Task>();
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getAllEmployee();
		taskList = taskDAO.getAllTasks();
		mav.addObject("listEmp", empList);
		mav.addObject("listTask", taskList);
		boolean update;
		update = taskDAO.updateTask(task.getAssignedToEmp(), task.getAssignedByEmp(),
				task.getAssignDate(), task.getDueDate(), task.getFinishDate(), task.getNote(), task.getComments(),
				task.getProjectName(), task.getTaskName());
		if (update) {
			mav.addObject("message", "Task updated");
		}else {
			mav.addObject("message", "Not updated");
		}
		return mav;
	}
	
	
	
	@RequestMapping(value = "/add-task", method=RequestMethod.POST)
	public ModelAndView addTask(@ModelAttribute("task") Task task, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("addTask");
			return mav;
		}
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getAllEmployee();
		ModelAndView mav = new ModelAndView("addTask");
		TaskDAO taskDAO = new TaskDAO();
		boolean addTask = true;
		System.out.println(task.getAssignedToEmp());
		System.out.println(task.getAssignedByEmp());
		addTask = taskDAO.addTask(task.getTaskName(), task.getAssignedToEmp(), task.getAssignedByEmp(),
				task.getAssignDate(), task.getDueDate(), task.getComments(), task.getNote(), task.getProjectName());
		if (addTask) {
			mav.addObject("message", "Task Added");
			mav.addObject("listEmp", empList);
			return mav;
		}else {
			mav.addObject("message", "Failed to add Task");
			return mav;
		}
	}
	
	
//	@RequestMapping(value = "/edit-task", method=RequestMethod.POST)
//	public ModelAndView editTask(@ModelAttribute("task") Task task, BindingResult errors) {
//		ModelAndView mav = new ModelAndView("editTask");
//		return mav;
//	}
	
	@RequestMapping(value = "/edit-task", method=RequestMethod.GET)
	public ModelAndView editTask(@ModelAttribute("task") Task task, BindingResult errors) {
		ModelAndView mav = new ModelAndView("editTask");
		TaskDAO taskDAO = new TaskDAO();
		List<Task> taskList = new ArrayList<Task>();
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getAllEmployee();
		taskList = taskDAO.getAllTasks();
		mav.addObject("listEmp", empList);
		mav.addObject("listTask", taskList);
		return mav;
	}
	
	
	
	
	@ModelAttribute("task")
	public Task setupUserModel(String taskName, String assignedToEmp, String assignedByEmp, String assignDate, String dueDate,
			String finishDate, String comments, String note, String projectName) {
		return new Task(taskName, assignedToEmp, assignedByEmp, assignDate, dueDate, finishDate, comments, note, projectName);
	}

}
