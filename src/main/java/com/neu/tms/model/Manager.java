package com.neu.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


public class Manager extends User {
	
	Project project;
	List<Task> tasks=new ArrayList<Task>();
	

}
