package com.neu.tms.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.neu.tms.configurations.TaskSeverity;
import com.neu.tms.configurations.TaskStatus;

@Entity
@Table(name="Task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="taskID")
	private long id;
	private String name;
	private String description;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="projectId")
	private Project project;
	@Enumerated(EnumType.STRING)
	private TaskSeverity taskSeverity;
	@Enumerated(EnumType.STRING)
	private TaskStatus taskStatus;
	private Date dueDate;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="assignedUserId")
	private User assignedTo;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="createdUserId")
	private User createdBy;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(String name, String description, Project project, TaskSeverity taskSeverity, TaskStatus taskStatus,
			Date dueDate, User assignedTo, User createdBy) {
		super();
		this.name = name;
		this.description = description;
		this.project = project;
		this.taskSeverity = taskSeverity;
		this.taskStatus = taskStatus;
		this.dueDate = dueDate;
		this.assignedTo = assignedTo;
		this.createdBy = createdBy;
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
	public TaskSeverity getTaskSeverity() {
		return taskSeverity;
	}
	public void setTaskSeverity(TaskSeverity taskSeverity) {
		this.taskSeverity = taskSeverity;
	}
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public User getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
