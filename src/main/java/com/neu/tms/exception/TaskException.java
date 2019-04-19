package com.neu.tms.exception;

public class TaskException extends Exception {

	public TaskException(String message) {
		super("TaskException-" + message);
	}

	public TaskException(String message, Throwable cause) {
		super("TaskException-" + message, cause);
	}
}