package com.Birds.Breeders.Model;

import java.time.LocalDate;
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
	private String sexo;
	@Column
	private Integer numAnilla;
	@Column
	private String especie;
	@Column
	private String nomCientif;
	@Column
	private String color;
	
	@OneToMany(mappedBy = "birds", fetch = FetchType.LAZY)
	private List<Specimen> specimen;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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




	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
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

	public void setNomCientif(String nomCientif) {
		this.nomCientif = nomCientif;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Specimen> getSpecimen() {
		return specimen;
	}

	public void setSpecimen(List<Specimen> specimen) {
		this.specimen = specimen;
	}

	public Breeder getBreeder() {
		return breeder;
	}

	public void setBreeder(Breeder breeder) {
		this.breeder = breeder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breeder == null) ? 0 : breeder.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((fNac == null) ? 0 : fNac.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomCientif == null) ? 0 : nomCientif.hashCode());
		result = prime * result + ((numAnilla == null) ? 0 : numAnilla.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((specimen == null) ? 0 : specimen.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Birds [id=" + id + ", fNac=" + fNac + ", sexo=" + sexo + ", numAnilla=" + numAnilla + ", especie="
				+ especie + ", nomCientif=" + nomCientif + ", color=" + color + ", specimen=" + specimen + ", breeder="
				+ breeder + "]";
	}

	public Birds() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Birds(Long id, LocalDate fNac, String sexo, Integer numAnilla, String especie, String nomCientif,
			String color, List<com.Birds.Breeders.Model.Specimen> specimen, Breeder breeder) {
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

	
	

}
