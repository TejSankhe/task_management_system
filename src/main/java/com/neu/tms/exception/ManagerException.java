package com.neu.tms.exception;

public class ManagerException extends Exception {

	public ManagerException(String message)
	{
		super("ManagerException-"+message);
	}
	
	public ManagerException(String message, Throwable cause)
	{
		super("ManagerException-"+message,cause);
	}
	
}
