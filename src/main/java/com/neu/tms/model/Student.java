package com.neu.tms.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Student extends User {
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

	public Student(String emailId, String password, Project project) {
		super(emailId, password);
		this.project = project;
	}


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="projectId")
	Project project;
	@OneToMany(mappedBy="assignedTo", cascade = CascadeType.ALL)
	Set<Task> tasksAssigned = new HashSet();
	@OneToMany(mappedBy="createdBy", cascade = CascadeType.ALL)
	Set<Task> tasksCreated=new HashSet();
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Set<Task> getTasksAssigned() {
		return tasksAssigned;
	}
	public void setTasksAssigned(Set<Task> tasksAssigned) {
		this.tasksAssigned = tasksAssigned;
	}
	public Set<Task> getTasksCreated() {
		return tasksCreated;
	}
	public void setTasksCreated(Set<Task> tasksCreated) {
		this.tasksCreated = tasksCreated;
	}
	public Student(Project project, Set<Task> tasksAssigned, Set<Task> tasksCreated) {
		super();
		this.project = project;
		this.tasksAssigned = tasksAssigned;
		this.tasksCreated = tasksCreated;
	}
	
	
	
}
