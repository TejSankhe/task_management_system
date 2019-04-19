package com.neu.tms.exception;

public class ProjectException extends Exception {

	public ProjectException(String message) {
		super("ProjectException-" + message);
	}

	public ProjectException(String message, Throwable cause) {
		super("ProjectException-" + message, cause);
	}
}