package spring.girish.ExceptionHandling.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {
	@ExceptionHandler(value=NullPointerException.class)	
	public String handleNPE(Exception e) {
		System.out.println("Null pointer Exception occured");
		return "NullPointerException";
	}
	
	//@ResponseStatus is used to send required error code to client in response object
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)	
	public String handleGenericException(Exception e) {
		System.out.println("Exception occured");
		return "Exception";
	}

}
