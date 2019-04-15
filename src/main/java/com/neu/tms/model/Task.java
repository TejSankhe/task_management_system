package com.neu.tms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

enum TaskSeverity {
	HIGH,LOW,MEDIUM;
}
enum TaskStatus {
	NOTASSIGNED,NOTSTARTED,INPROGRESS,COMPLETED,NOTTODO ;
}
@Entity
@Table(name="Task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="taskID")
	private long id;
	private String name;
	private String description;
	private Project project;
	private TaskSeverity taskSeverity;
	private TaskStatus taskStatus;
	private Date dueDate;
	private User assignedTo;
	private User createdBy;
	//comments
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
