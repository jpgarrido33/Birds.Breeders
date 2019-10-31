package com.Birds.Breeders.Utils;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author jpgarrido
 * Realiza la validacion para sexo de la entidad Birds
 */

@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = StringEnumerationValidator.class)

public @interface ValidSexo {

  String message() default "{El valor debe ser MACHO ó HEMBRA}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};



}
