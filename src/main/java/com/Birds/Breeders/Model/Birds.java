package com.Birds.Breeders.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.Birds.Breeders.Utils.EnumSexo;

@Entity
public class Birds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	
	@Column(unique = true, updatable = false)
	private Long id;
	@Column
	private LocalDate fNac;
	@Column
	private EnumSexo sexo;
	@Column(unique = true)
	private Integer numAnilla;
	@Column
	private String especie;
	@Column
	private String nomCientif;
	@Column
	private String color;
	

	@ManyToOne(fetch = FetchType.LAZY)
	private Specimen specimen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Breeder breeder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getfNac() {
		return fNac;
	}

	public void setfNac(LocalDate fNac) {
		this.fNac = fNac;
	}


//	public String getSexo() {
//		return sexo;
//	}
//
//	public void setSexo(String sexo) {
//		this.sexo = sexo;
//	}
	
	

	public Integer getNumAnilla() {
		return numAnilla;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public Specimen getSpecimen() {
		return specimen;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
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

	public void setNomCientif(String nomCientif) {
		this.nomCientif = nomCientif;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public Specimen getSpemcimen() {
		return specimen;
	}

	public void setSpemcimen(Specimen spemcimen) {
		this.specimen = spemcimen;
	}

	public Breeder getBreeder() {
		return breeder;
	}

	public void setBreeder(Breeder breeder) {
		this.breeder = breeder;
	}



	public Birds() {
		super();
		
	}

	public Birds(Long id, LocalDate fNac, EnumSexo sexo, Integer numAnilla, String especie, String nomCientif,
			String color, Specimen specimen, Breeder breeder) {
		super();
		this.id = id;
		this.fNac = fNac;
		this.sexo = sexo;
		this.numAnilla = numAnilla;
		this.especie = especie;
		this.nomCientif = nomCientif;
		this.color = color;
		this.specimen = specimen;
		this.breeder = breeder;
	}

//	public Birds(Long id, LocalDate fNac, String sexo, Integer numAnilla, String especie, String nomCientif,
//			String color, Specimen spemcimen, Breeder breeder) {
//		super();
//		this.id = id;
//		this.fNac = fNac;
//		this.sexo = sexo;
//		this.numAnilla = numAnilla;
//		this.especie = especie;
//		this.nomCientif = nomCientif;
//		this.color = color;
//		this.specimen = spemcimen;
//		this.breeder = breeder;
//	}



	
	

}
