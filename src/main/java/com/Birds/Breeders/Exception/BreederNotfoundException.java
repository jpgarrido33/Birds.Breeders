package com.Birds.Breeders.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BreederNotfoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String message="Criador no encontrado";
	
	public BreederNotfoundException() {
		
		super(message);
	}

}
