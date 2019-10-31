package com.Birds.Breeders.Exception;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BirdsDuplicateException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private static final String message="Registro duplicado";
//	
	public BirdsDuplicateException(){
//		SQLException e=new SQLException();
//		
//		 if (e.getErrorCode() == 1062)
//             JOptionPane.showMessageDialog (null, "ya existe!", "Num anilla Duplicada", 
//                    JOptionPane.ERROR_MESSAGE);
		super(message);
	}
	
}
