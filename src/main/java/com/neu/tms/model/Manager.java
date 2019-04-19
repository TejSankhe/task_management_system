package com.neu.tms.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@NamedQueries({
	@NamedQuery(name="Manager.getAllManager" , query="from Manager"),
	@NamedQuery(name="Manager.getAllManagerEmailAddress" , query="select emailId from Manager")
})

public class Manager extends User {
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String emailId, String password, Project project, Set<Task> tasks, Set<Task> tasksCreated) {
		super(emailId, password);
		this.project = project;
		this.tasks = tasks;
		this.tasksCreated = tasksCreated;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Project project;
	@OneToMany(mappedBy="assignedTo", cascade = CascadeType.ALL)
	Set<Task> tasks=new HashSet();
	@OneToMany(mappedBy="createdBy", cascade = CascadeType.ALL)
	Set<Task> tasksCreated=new HashSet();
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Task> getTasksCreated() {
		return tasksCreated;
	}

	public void setTasksCreated(Set<Task> tasksCreated) {
		this.tasksCreated = tasksCreated;
	}

	@Override
	public String toString() {
		return "Manager [project=" + project + ", tasks=" + tasks + ", tasksCreated=" + tasksCreated + "]";
	}
	
	

}
