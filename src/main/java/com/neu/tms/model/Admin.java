package com.neu.tms.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String emailId, String password) {
		super(emailId, password);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
