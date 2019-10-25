package com.Birds.Breeders.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class SpecimenDTO {
	@NotNull (message=" el valor no puede ser nulo")
	private Long id;
	@NotBlank(message="El campo nombre de especie no puede estar en  blanco")
	private String nombreespecie;
}
