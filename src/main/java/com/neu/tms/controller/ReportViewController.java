package com.neu.tms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.tms.configurations.TaskSeverity;
import com.neu.tms.configurations.TaskStatus;
import com.neu.tms.dao.TaskDao;
import com.neu.tms.model.Task;
import com.neu.tms.utilities.PdfReport;

@Controller
@RequestMapping("/*")
public class ReportViewController {
	
	@RequestMapping(value= "/pdfviewoftask", method = RequestMethod.GET)
	public ModelAndView createReport(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String,Object>(); 
		TaskDao taskDao = new TaskDao();
		long issueId= Long.parseLong(request.getParameter("id"));
		try {
			Task task = taskDao.getTask(issueId);
			map.put("task", task);
			return new ModelAndView(new PdfReport(),map);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while fecting task");
		}
	}

}
