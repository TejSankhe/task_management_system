package com.neu.tms.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.tms.dao.ManagerDao;
import com.neu.tms.dao.RequestDao;
import com.neu.tms.dao.StudentDao;
import com.neu.tms.dao.UserDao;
import com.neu.tms.exception.UserException;
import com.neu.tms.model.Manager;
import com.neu.tms.model.Student;
import com.neu.tms.model.Task;
import com.neu.tms.model.User;
import com.neu.tms.model.UserRequest;

@Controller
@RequestMapping("/*")
public class AdminController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView goToAdminHomePage(HttpServletRequest request, HttpServletResponse response) {
		RequestDao requestDao = new RequestDao();
		try {
			List<UserRequest> requests = requestDao.getRequests();
			return new ModelAndView("adminHome","requests",requests);
		} catch (Exception e) {
			return new ModelAndView("error", "errorMessage", "Error while retrieving user requests");
		}
	}
	
	@RequestMapping(value = "/deleteRequest/{id}", method = RequestMethod.GET)
	public ModelAndView deleteRequest(@PathVariable String id,HttpServletRequest request) {
		RequestDao requestDao = new RequestDao();
		try {
			long requestId = Long.parseLong(id);
			UserRequest userRequest = requestDao.getUserRequestById(requestId);
			requestDao.deleteRequest(userRequest);
			return new ModelAndView("redirect:/admin");
		} catch ( Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while deleting request");
		} 
	}

}
