package com.neu.tms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.tms.dao.TaskDao;
import com.neu.tms.dao.UserDao;
import com.neu.tms.exception.TaskException;
import com.neu.tms.model.Admin;
import com.neu.tms.model.Manager;
import com.neu.tms.model.Student;
import com.neu.tms.model.Task;
import com.neu.tms.model.User;
import com.neu.tms.validation.TaskValidator;


@Controller
@RequestMapping("/*")
public class TaskController {
	
	@RequestMapping(value = "/addnewTask", method = RequestMethod.GET)
	protected ModelAndView addNewTask() throws Exception {
		System.out.print("add new Task");
		return new ModelAndView("add_task", "task", new Task());

	}
	
	@RequestMapping(value = "/addnewTask", method = RequestMethod.POST)
	protected ModelAndView addNewTask(HttpServletRequest request, @Validated @ModelAttribute("task") Task task, BindingResult result) throws Exception {
		TaskValidator taskValidator =  new TaskValidator();
		taskValidator.validate(task, result);

		if (result.hasErrors()) {
			return new ModelAndView("add_task", "task", task);
		}
		
		TaskDao taskDao = new TaskDao();
		UserDao userDao = new UserDao();
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("user");
		String assignedToID = request.getParameter("assignedToUser").toString();
		User assignedTo;
				if(manager.getEmailId().equalsIgnoreCase(assignedToID)) {
					assignedTo = manager;
				}else
				{
					assignedTo = userDao.getUser(assignedToID);
				}
		
		task.setCreatedBy(manager);
		task.setProject(manager.getProject());
		task.setAssignedTo(assignedTo);
		try {				
			taskDao.create(task);
			System.out.print("Task added");	
			HttpSession Httpsession = request.getSession();
			User u = (User) Httpsession.getAttribute("user");
			if (u instanceof Manager) {
				return new ModelAndView("redirect:/manager");
			} else if (u instanceof Student) {
				return new ModelAndView("redirect:/student");
			} else if (u instanceof Admin) {
				return new ModelAndView("redirect:/admin");
			}
			return new ModelAndView("success");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while creating task");
		}
		
	}
	
	
	
	@RequestMapping(value="/viewTask", method =  RequestMethod.GET)
	public ModelAndView  viewTask(HttpServletRequest request)
	{
		TaskDao taskDao = new TaskDao();
		long issueId= Long.parseLong(request.getParameter("id"));
		try {
			Task task = taskDao.getTask(issueId);
			return new ModelAndView("view-task","task",task);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while fecting task");
		}
	}
	
	
	@RequestMapping(value = "/updateTask", method = RequestMethod.GET)
	protected ModelAndView UpdateTask(HttpServletRequest request) throws Exception {
		TaskDao taskDao = new TaskDao();
		long taskId= Long.parseLong(request.getParameter("id"));
		try {
			Task task = taskDao.getTask(taskId);
			System.out.println(task);
			return new ModelAndView("edit_task","updatedTask",task);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while fecting task");
		}

	}
	
	@RequestMapping(value = "/updatedTask", method = RequestMethod.POST)
	protected ModelAndView UpdateTask(HttpServletRequest request, @Validated @ModelAttribute("updatedTask") Task task, BindingResult result) throws Exception {
		TaskValidator taskValidator =  new TaskValidator();
		taskValidator.validate(task, result);

		if (result.hasErrors()) {
			return new ModelAndView("edit_task", "issue", task);
		}
		
		TaskDao taskDao = new TaskDao();
		UserDao userDao = new UserDao();
		long issueId= Long.parseLong(request.getParameter("id"));
		try {
			Task oldtask = taskDao.getTask(issueId);
//		HttpSession session = request.getSession();
//		Manager manager = (Manager) session.getAttribute("user");
		User assignedTo = userDao.getUser(request.getParameter("assignedTouser").toString());
//		task.setCreatedBy(manager);
//		task.setProject(manager.getProject());
		task.setAssignedTo(assignedTo);		
		task.setCreatedBy(oldtask.getCreatedBy());
		task.setDueDate(oldtask.getDueDate());
		task.setProject(oldtask.getProject());
		task.setId(oldtask.getId());
			taskDao.update(task);
			System.out.print("Task updated");
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			if (u instanceof Manager) {
				return new ModelAndView("redirect:/manager");
			} else if (u instanceof Student) {
				return new ModelAndView("redirect:/student");
			} else if (u instanceof Admin) {
				return new ModelAndView("redirect:/admin");
			}
			return new ModelAndView("success");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while updating task");
		}
		
	}
}
