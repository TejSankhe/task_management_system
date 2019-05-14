package com.neu.tms.security;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class Interceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String resourceMatcher="/tms/resources/.*";
		 boolean resourceFolder = Pattern.matches(resourceMatcher, request.getRequestURI().toString());
		if (request.getRequestURI().toString().equals("/tms/login") || resourceFolder || request.getRequestURI().toString().equals("/tms/unauthorizedRequest")|| request.getRequestURI().toString().equals("/tms/requestToAddProject") || request.getRequestURI().toString().equals("/tms/user_not_found") || request.getRequestURI().toString().equals("/tms/error")) {
			return true;
		} else {
			if(session.getAttribute("user")==null)
			{
				response.sendRedirect("/tms/unauthorizedRequest");
				return false;
			}
			else
			{
				return true;
			}
			
		}

	}
}