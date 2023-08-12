package com.virtusa.healthcareproviderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHealthProviderHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(JWTNotValidException.class)
	public ResponseEntity<ErrorModel> handleJwtNotValidException(Exception ex)
	{
		ErrorModel em = new ErrorModel();
		em.setErrorCode("ERR002");
		em.setErrorMessage("JWT token is not valid");
		return new ResponseEntity<ErrorModel>(em, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	 @ExceptionHandler(AccountCreationException.class)
	    public ResponseEntity<ErrorModel> handleAccountCreationException(AccountCreationException ex) {
	        ErrorModel errorResponse = new ErrorModel(HttpStatus.BAD_REQUEST.toString(),ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	    }
}
