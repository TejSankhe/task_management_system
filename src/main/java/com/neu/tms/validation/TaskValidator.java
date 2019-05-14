package com.neu.tms.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.tms.model.Task;

public class TaskValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Task.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Task issue= (Task)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskSeverity", "error.invalid.taskSeverity", "Severity of task Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskStatus", "error.invalid.taskStatus", "Status of task Required");
		
	}

}
