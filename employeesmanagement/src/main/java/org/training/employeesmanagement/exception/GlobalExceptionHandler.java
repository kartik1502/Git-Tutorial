package org.training.employeesmanagement.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorDetails = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorDetails.add(error.getDefaultMessage());
		}
		ErrorResponse response = new ErrorResponse(400l, errorDetails);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = EmployeeAlreadyExists.class)
	public ResponseEntity<Object> exception(EmployeeAlreadyExists exception) {
		return new ResponseEntity<>("Employee already exists", HttpStatus.CONFLICT);

	}
  
  @ExceptionHandler(value = NoSuchEmployeeExists.class)
	public ResponseEntity<Object> exception(NoSuchEmployeeExists exception) {
		return new ResponseEntity<>("No such employee exists", HttpStatus.NOT_FOUND);
	}
}


