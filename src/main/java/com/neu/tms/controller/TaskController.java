package com.neu.tms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.tms.dao.TaskDao;
import com.neu.tms.model.Task;


@Controller
@RequestMapping("/*")
public class TaskController {
	
	@RequestMapping(value = "/addnewTask", method = RequestMethod.GET)
	protected ModelAndView addNewTask() throws Exception {
		System.out.print("add new Task");
		return new ModelAndView("add_task", "task", new Task());

	}
	
	@RequestMapping(value = "/addnewTask", method = RequestMethod.POST)
	protected ModelAndView adminAddNewCar(HttpServletRequest request,  @ModelAttribute("task") Task task, BindingResult result) throws Exception {
		
		//issueValidator.validate(issue, result);

//		if (result.hasErrors()) {
//			return new ModelAndView("add-new-issue", "issue", issue);
//		}
		TaskDao taskDao = new TaskDao();

		try {

						
			Boolean issueCreated = taskDao.create(task);				
		
			//request.getSession().setAttribute("car", c);
			System.out.print("New Task Created");	
			return new ModelAndView("success");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while creating task");
		}
		
	}
	
//	@RequestMapping(value="/viewIssue", method =  RequestMethod.GET)
//	public ModelAndView  viewIssue(HttpServletRequest request)
//	{
//		long issueId= Long.parseLong(request.getParameter("id"));
//		try {
//			Issue issue= issueDAO.getIssueById(issueId);
//			return new ModelAndView("view-issue","issue",issue);
//		} catch (IssueException e) {
//			System.out.println("Exception: " + e.getMessage());
//			return new ModelAndView("error", "errorMessage", "error while fecting issue");
//		}
//	}
}
