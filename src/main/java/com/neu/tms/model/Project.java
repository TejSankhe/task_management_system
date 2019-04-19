package com.neu.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projectId")
	private long id;
	private String name;
	private String description;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Manager manager;
	@OneToMany(mappedBy="project", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList();
	@OneToMany(mappedBy="project", cascade = CascadeType.ALL)
	private List<Task> tasks = new ArrayList();
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(String name, String description, Manager manager, List<Student> students, List<Task> tasks) {
		super();
		this.name = name;
		this.description = description;
		this.manager = manager;
		this.students = students;
		this.tasks = tasks;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
