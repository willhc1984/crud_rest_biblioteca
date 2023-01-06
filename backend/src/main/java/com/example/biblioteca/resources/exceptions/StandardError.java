package com.example.biblioteca.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String error;
	private String path;
	private String message;
	private List<ValidationError> validations;
	
	public StandardError() {
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ValidationError> getValidations() {
		return validations;
	}

	public void setValidations(List<ValidationError> validations) {
		this.validations = validations;
	}

}
