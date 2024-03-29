package com.Birds.Breeders.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.Birds.Breeders.Utils.EnumSexo;


@Component
public class BreederDTO {
	
	private Long id;
	@NotNull(message="El valor no puede ser nulo")
	private Integer numCriador;
	@NotBlank(message="El campo nombre no puede estar en  blanco")
	private String Nombre;
	@NotBlank(message="El campo apellidos no puede estar en  blanco")
	private String apellidos;
	@NotBlank(message="El campo fecha nacimiento no puede estar en  blanco")
	private String fNac;
	
	private String Sexo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumCriador() {
		return numCriador;
	}
	public void setNumCriador(Integer numCriador) {
		this.numCriador = numCriador;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	
	
	public String getfNac() {
		return fNac;
	}
	public void setfNac(String fNac) {
		this.fNac = fNac;
	}
	public BreederDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BreederDTO(@NotNull(message = "El valor no puede ser nulo") Long id,
			@NotNull(message = "El valor no puede ser nulo") Integer numCriador,
			@NotBlank(message = "El campo nombre no puede estar en  blanco") String nombre,
			@NotBlank(message = "El campo apellidos no puede estar en  blanco") String apellidos,
			@NotBlank(message = "El campo fecha nacimiento no puede estar en  blanco") String fNac, String sexo) {
		super();
		this.id = id;
		this.numCriador = numCriador;
		Nombre = nombre;
		this.apellidos = apellidos;
		this.fNac = fNac;
		Sexo = sexo;
	}
	
	
	
}
