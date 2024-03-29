package com.Birds.Breeders.Controller;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import com.Birds.Breeders.Exception.Error;
import com.Birds.Breeders.Exception.SpecimenNotFoundException;
import com.Birds.Breeders.Exception.BirdNotFoundException;
import com.Birds.Breeders.Exception.BirdsDuplicateException;
import com.Birds.Breeders.Exception.BreederNotfoundException;

@ControllerAdvice
public class ControllerExceptionAdvice {

	 private Error errorDetail;
	 
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(BirdNotFoundException.class) 
		public ResponseEntity<Error> birdNotFoundException(BirdNotFoundException ex, WebRequest request) {
		errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND); 
		}
		
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(BreederNotfoundException.class) 
		public ResponseEntity<Error> breederNotfoundException(BreederNotfoundException ex, WebRequest request) {
		errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND); 
		}
		
		
		
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(SpecimenNotFoundException.class) 
		public ResponseEntity<Error> specimenNotFoundException(SpecimenNotFoundException ex, WebRequest request) {
		errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND); 
		}
		
		@ResponseBody
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(BirdsDuplicateException.class) 
		public ResponseEntity<Error> birdsDuplicateException(BirdsDuplicateException ex, WebRequest request) {
		errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	
}
