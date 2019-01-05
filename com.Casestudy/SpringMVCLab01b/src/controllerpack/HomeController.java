package controllerpack;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import models.ContactInfo;
import models.PrivateInfo;
import models.User;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView displayHomePage() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView displayForm(@ModelAttribute("user") User user, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("home");
			return mav;
		}
		ModelAndView mav = new ModelAndView("form");
		return mav;
	}
	
	@RequestMapping(value="/process-form", method=RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("user") User user, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("form");
			return mav;
		}
		ModelAndView mav = new ModelAndView("submission-details");
		return mav;
	}

	@ModelAttribute("user")
	public User setUserForm(String fname, String lname, String uname, String gender, ContactInfo contactInfo, PrivateInfo privateInfo) {
		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setGender(gender);
		user.setUname(uname);
		user.setContactInfo(contactInfo);
		user.setPrivateInfo(privateInfo);
		return user;
	}
}
