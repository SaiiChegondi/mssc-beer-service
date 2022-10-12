package guru.springframework.msscbeerservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MvcExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List> validationerror(ConstraintViolationException e)
	{
		List<String> errorList=new ArrayList<>(e.getConstraintViolations().size());
		e.getConstraintViolations().forEach(error -> errorList.add(error.toString()));
		return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);
	}
}
