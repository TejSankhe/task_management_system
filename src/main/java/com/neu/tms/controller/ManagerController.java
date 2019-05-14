package com.neu.tms.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.tms.dao.ManagerDao;
import com.neu.tms.dao.StudentDao;
import com.neu.tms.dao.UserDao;
import com.neu.tms.exception.UserException;
import com.neu.tms.model.Manager;
import com.neu.tms.model.Student;
import com.neu.tms.model.Task;
import com.neu.tms.model.User;

@Controller
@RequestMapping("/*")
public class ManagerController {
	
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public ModelAndView goManagersHomePage(HttpServletRequest request, HttpServletResponse response) {
		Set<Task> tasks = null;
		User user = (User) request.getSession().getAttribute("user");
		ManagerDao managerDao = new ManagerDao();
		try {
			Manager manager = (Manager) managerDao.getManagerByEmailAddress(user.getEmailId());
			manager.setTasks(managerDao.getAllTasksOfManager(user.getEmailId()));
			System.out.println(managerDao.getAllTasksOfManager(user.getEmailId()).size());
			return new ModelAndView("managerHome","manager",manager);
		} catch (Exception e) {
			return new ModelAndView("error", "errorMessage", "Error while retrieving tasks of manager");
		}
	}
}
