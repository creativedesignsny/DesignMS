/**
 * 
 */
package com.Casestudy.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.DAO.ProfileDAO;
import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Profile;

/**
 * @author amahome
 *
 */

@Controller
@RequestMapping("/")
public class ProfileController {
	
	
	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	public ModelAndView displayProfile(HttpSession session) {
		ModelAndView mav = new ModelAndView ("profile");
		String empemail = (String)session.getAttribute("empEmail");
		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		Profile profile = new Profile();
		ProfileDAO profileDAO = new ProfileDAO();
		emp = empDAO.getEmployeeByEmail(empemail);
		profile = profileDAO.getEmpProfileByEmail(empemail);
		mav.addObject("employee", emp);
		mav.addObject("empprofile", profile);
		return mav;
	}
}
