package com.Birds.Breeders.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.Birds.Breeders.Utils.EnumSexo;
import com.Birds.Breeders.Utils.StringEnumeration;

@Component
public class BreederDTO {
	@NotNull(message="El valor no puede ser nulo")
	private Long id;
	@NotNull(message="El valor no puede ser nulo")
	private Integer numCriador;
	@NotBlank(message="El campo nombre no puede estar en  blanco")
	private String Nombre;
	@NotBlank(message="El campo apellidos no puede estar en  blanco")
	private String apellidos;
	@NotBlank(message="El campo fecha nacimiento no puede estar en  blanco")
	private String Fnac;
	@StringEnumeration(enumClass = EnumSexo.class) // creamos una anotacion para que solo valide MACHO o HEMBRA
	private EnumSexo Sexo;
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
	public String getFnac() {
		return Fnac;
	}
	public void setFnac(String fnac) {
		Fnac = fnac;
	}
	public EnumSexo getSexo() {
		return Sexo;
	}
	public void setSexo(EnumSexo sexo) {
		Sexo = sexo;
	}
	@Override
	public String toString() {
		return "BreederDTO [id=" + id + ", numCriador=" + numCriador + ", Nombre=" + Nombre + ", apellidos=" + apellidos
				+ ", Fnac=" + Fnac + ", Sexo=" + Sexo + "]";
	}
	public BreederDTO(Long id, Integer numCriador, String nombre, String apellidos, String fnac, EnumSexo sexo) {
		super();
		this.id = id;
		this.numCriador = numCriador;
		Nombre = nombre;
		this.apellidos = apellidos;
		Fnac = fnac;
		Sexo = sexo;
	}
	public BreederDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
