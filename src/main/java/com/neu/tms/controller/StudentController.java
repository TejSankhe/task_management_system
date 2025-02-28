package com.neu.tms.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class StudentController {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView goToStudentHomePage(HttpServletRequest request, HttpServletResponse response) {
		Set<Task> tasks = null;
		User user = (User) request.getSession().getAttribute("user");
		StudentDao studentDao = new StudentDao();
		try {
			Student student = (Student) studentDao.getStudenrByEmailAddress(user.getEmailId());
			Set<Task> tempTask = studentDao.getAllTasksOfStudent(user.getEmailId());
			Set<Task> taskAssigned = new HashSet<Task>();
			for(Task t : tempTask) {
				taskAssigned.add(t);
			}
			student.setTasksAssigned(taskAssigned);
			System.out.println(taskAssigned);
			System.out.println(taskAssigned);
			return new ModelAndView("studentHome","student",student);
		} catch (Exception e) {
			e.getStackTrace();
			return new ModelAndView("error", "errorMessage", "Error while retrieving tasks of student");
		}
	}
}
