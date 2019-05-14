package com.neu.tms.utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import com.neu.tms.model.UserRequest;

public class Mailer {

	public static boolean sendMail(UserRequest requestForProjectAssignment) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(587);
			//User your gmail username and password
			email.setAuthenticator(new DefaultAuthenticator("tejsankhetest@gmail.com", "Tej1234567890"));
			email.setSSLOnConnect(true);
			email.setFrom("tejsankhetest@gmail.com");
			email.setSubject("Request to give task mangement system access project name: "+requestForProjectAssignment.getProjectname());
			email.setMsg("Users id: "+requestForProjectAssignment.getEmail()+"\nComment: "+requestForProjectAssignment.getComment());
			email.addTo("sankhe.t@husky.neu.edu");
			email.send();
			return true;
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
	}
}
