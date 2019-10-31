package com.Birds.Breeders.DTO;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.Birds.Breeders.Model.Breeder;
import com.Birds.Breeders.Utils.EnumSexo;
import com.Birds.Breeders.Utils.StringEnumerationValidator;
import com.Birds.Breeders.Utils.ValidSexo;

@Component
public class BirdsDTO {

	
	private Long id;
	@NotBlank(message = "Debe especificar una fecha: yyyy-mm-aa")
	private String fNac;
	
	@NotBlank
	@ValidSexo
	private String sexo; // MACHO o HEMBRA
	@NotNull
	private Integer numAnilla;
	@NotBlank
	private String especie;
	@NotBlank
	private String nomCientif;
	@NotBlank
	private String color;
	
	private BreederDTO breederDto;
	
	private SpecimenDTO specimenDto;
	

	
	



	
		public SpecimenDTO getSpecimenDto() {
		return specimenDto;
	}
	public void setSpecimenDto(SpecimenDTO specimenDto) {
		this.specimenDto = specimenDto;
	}
		public BreederDTO getBreederDto() {
		return breederDto;
	}
	public void setBreederDto(BreederDTO breederDto) {
		this.breederDto = breederDto;
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
	
	

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
//	public EnumSexo getSexo() {
//		return sexo;
//	}
//	public void setSexo(EnumSexo sexo) {
//		this.sexo = sexo;
//	}

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
				+ especie + ", nomCientif=" + nomCientif + ", color=" + color + ", breederDto=" + breederDto + "]";
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
			@NotBlank(message = "Debe especificar una fecha: yyyy-mm-aa") String fNac, String sexo, Integer numAnilla,
			String especie, String nomCientif, String color, BreederDTO breederDto, SpecimenDTO specimenDto) {
		super();
		this.id = id;
		this.fNac = fNac;
		this.sexo = sexo;
		this.numAnilla = numAnilla;
		this.especie = especie;
		this.nomCientif = nomCientif;
		this.color = color;
		this.breederDto = breederDto;
		this.specimenDto = specimenDto;
	}
//	public BirdsDTO(@NotNull(message = "el valor no puede ser nulo") Long id,
//			@NotBlank(message = "Debe especificar una fecha: yyyy-mm-aa") String fNac, String sexo, Integer numAnilla,
//			String especie, String nomCientif, String color, BreederDTO breederDto) {
//		super();
//		this.id = id;
//		this.fNac = fNac;
//		this.sexo = sexo;
//		this.numAnilla = numAnilla;
//		this.especie = especie;
//		this.nomCientif = nomCientif;
//		this.color = color;
//		this.breederDto = breederDto;
//	}
	public BirdsDTO() {
		// TODO Auto-generated constructor stub
	}
	


	
	
}
