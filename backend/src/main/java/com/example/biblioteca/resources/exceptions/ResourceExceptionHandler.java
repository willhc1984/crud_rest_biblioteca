package com.example.biblioteca.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.biblioteca.services.exceptions.DataBaseException;
import com.example.biblioteca.services.exceptions.EntityNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> handle(MethodArgumentNotValidException exception, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setError("Erro de validação de dados!");
		err.setMessage(exception.getMessage());
		err.setPath(request.getRequestURI());
		
		List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();
		List<ValidationError> list = new ArrayList<>();
		
		fieldErrorList.forEach(error -> {
			list.add(new ValidationError(error.getField(), error.getDefaultMessage()));
		});
		
		err.setValidations(list);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler
	public ResponseEntity<StandardError> handle(DataIntegrityViolationException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setError("Erro de integridade de dados!");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> emptyResult(DataBaseException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setError("Erro de integridade de chave");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
