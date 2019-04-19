package com.neu.tms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.tms.dao.StudentDao;
import com.neu.tms.dao.UserDao;
import com.neu.tms.exception.UserException;
import com.neu.tms.model.Student;
import com.neu.tms.model.Task;

@Controller
@RequestMapping("/*")
public class StudentController {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView goToStudentHomePage() {
		UserDao userDAO = new UserDao();
		StudentDao studentDao = new StudentDao();
		Set<Task> tasks = null;
		try {
			//Student student = (Student) userDAO.getUser("student.3@husky.neu.edu");
			tasks= studentDao.getAllTasksOfStudent("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("studentHome","tasks",tasks);
	}
}
