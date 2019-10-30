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
	
	private BirdsDTO birdsDto;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreespecie() {
		return nombreespecie;
	}
	public void setNombreespecie(String nombreespecie) {
		this.nombreespecie = nombreespecie;
	}
	@Override
	public String toString() {
		return "SpecimenDTO [id=" + id + ", nombreespecie=" + nombreespecie + "]";
	}
	public SpecimenDTO(@NotNull(message = " el valor no puede ser nulo") Long id,
			@NotBlank(message = "El campo nombre de especie no puede estar en  blanco") String nombreespecie) {
		super();
		this.id = id;
		this.nombreespecie = nombreespecie;
	}
	public SpecimenDTO() {
		super();
	
	}
	
	
}
