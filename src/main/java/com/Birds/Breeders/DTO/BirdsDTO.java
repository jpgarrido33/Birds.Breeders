package com.Birds.Breeders.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.Birds.Breeders.Model.Breeder;
import com.Birds.Breeders.Utils.EnumSexo;
@Component
public class BirdsDTO {

	@NotNull(message="el valor no puede ser nulo")
	private Long id;
	@NotBlank(message = "Debe especificar una fecha: yyyy-mm-aa")
	private String fNac;
	
	private EnumSexo sexo; // MACHO o HEMBRA
	private Integer numAnilla;
	private String especie;
	private String nomCientif;
	private String color;
	private Breeder breeder;
	
	

	public Breeder getBreeder() {
		return breeder;
	}
	public void setBreeder(Breeder breeder) {
		this.breeder = breeder;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getfNac() {
		return fNac;
	}
	public void setfNac(String fNac) {
		this.fNac = fNac;
	}
	public EnumSexo getSexo() {
		return sexo;
	}
	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}
	public Integer getNumAnilla() {
		return numAnilla;
	}
	public void setNumAnilla(Integer numAnilla) {
		this.numAnilla = numAnilla;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getNomCientif() {
		return nomCientif;
	}
	@Override
	public String toString() {
		return "BirdsDTO [id=" + id + ", fNac=" + fNac + ", sexo=" + sexo + ", numAnilla=" + numAnilla + ", especie="
				+ especie + ", nomCientif=" + nomCientif + ", color=" + color + ", breeder=" + breeder + "]";
	}
	public void setNomCientif(String nomCientif) {
		this.nomCientif = nomCientif;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	public BirdsDTO(@NotNull(message = "el valor no puede ser nulo") Long id,
			@NotBlank(message = "Debe especificar una fecha: yyyy-mm-aa") String fNac, EnumSexo sexo, Integer numAnilla,
			String especie, String nomCientif, String color, Breeder breeder) {
		super();
		this.id = id;
		this.fNac = fNac;
		this.sexo = sexo;
		this.numAnilla = numAnilla;
		this.especie = especie;
		this.nomCientif = nomCientif;
		this.color = color;
		this.breeder = breeder;
	}
	public BirdsDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
}
