package com.hackaton.unifacisa.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> Errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return Errors;
	}

	public void addError(String fieldName, String message) {
		this.Errors.add(new FieldMessage(fieldName, message));
	}
	
}
