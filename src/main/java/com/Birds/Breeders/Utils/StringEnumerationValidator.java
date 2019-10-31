package com.Birds.Breeders.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class StringEnumerationValidator implements ConstraintValidator<ValidSexo, String> {



	  @Override
	  public boolean isValid(String value, ConstraintValidatorContext context) {
		  

		  String strMacho= new String("MACHO");
		  String strHembra=new String("HEMBRA");
	
	    if ( value.equals(strMacho) || value.equals(strHembra)) {
	    	
	    	return true;
	      
	    } else {
	      return false;
	    }
	  }
}
