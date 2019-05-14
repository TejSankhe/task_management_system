package com.neu.tms.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.tms.dao.DAO;
import com.neu.tms.dao.UserDao;
import com.neu.tms.exception.UserException;
import com.neu.tms.model.Admin;
import com.neu.tms.model.Manager;
import com.neu.tms.model.Student;
import com.neu.tms.model.User;
import com.neu.tms.utilities.PasswordEncryption;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/unauthorizedRequest", method = RequestMethod.GET)
	public String unauthorizedRequest() {
		return "unauthorizedRequest";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage() {
		return "error";
	}
	@RequestMapping(value = "/user_not_found", method = RequestMethod.GET)
	public String invalidUserRequest() {
		return "user_not_found";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String formView(ModelMap model, User user) {
		model.addAttribute("user", user);
		return "user_login";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView successView(@ModelAttribute("user") User user, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {
		UserDao userDao = new UserDao();
		String encryptPassword = PasswordEncryption.encrypt(user.getPassword(), 12);
		User u;
		try {
			u = userDao.authenticateUser(user.getEmailId(), encryptPassword);
			if (u != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				if (u instanceof Manager) {
					return new ModelAndView("redirect:/manager");
				} else if (u instanceof Student) {
					return new ModelAndView("redirect:/student");
				} else if (u instanceof Admin) {
					return new ModelAndView("redirect:/admin");
				}
				
			}else {
				return new ModelAndView("redirect:/user_not_found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/error");
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model, User user, HttpServletRequest request) {

		HttpSession HTTPsession = (HttpSession) request.getSession();
		try {
			HTTPsession.invalidate();
			return new ModelAndView("user_login","user",new User());

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "Error while logging out");
		}
	}

}
