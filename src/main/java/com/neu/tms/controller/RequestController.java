package com.neu.tms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.tms.dao.RequestDao;
import com.neu.tms.model.Task;
import com.neu.tms.model.User;
import com.neu.tms.model.UserRequest;
import com.neu.tms.utilities.Mailer;
import com.neu.tms.validation.TaskValidator;

@Controller
public class RequestController {

	@RequestMapping(value = "/requestToAddProject", method = RequestMethod.GET)
	public String requestForm(ModelMap model, UserRequest userrequest) {
		model.addAttribute("userrequest", userrequest);
		return "requestToAddInProject";
	}
	
	@RequestMapping(value = "/requestToAddProject", method = RequestMethod.POST)
	protected ModelAndView sendRequest(HttpServletRequest request, @Validated @ModelAttribute("requestForProjectAssignment") UserRequest userrequest, BindingResult result) throws Exception {
	
		RequestDao requestDao = new RequestDao();
		requestDao.create(userrequest);
		if(Mailer.sendMail(userrequest)) {
		return new ModelAndView("success");
		}
		else {
			return new ModelAndView("error", "errorMessage", "Error while sending mail to admin try again");
		}
	}
	
	
	
}
