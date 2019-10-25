package com.Birds.Breeders.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Breeder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Long id;
	private Integer numCriador;
	private String Nombre;
	private String apellidos;
	private LocalDate Fnac;
	private String Sexo;
	

	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Birds> birds= new ArrayList<Birds>();



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



	public LocalDate getFnac() {
		return Fnac;
	}



	public void setFnac(LocalDate fnac) {
		Fnac = fnac;
	}



	public String getSexo() {
		return Sexo;
	}



	public void setSexo(String sexo) {
		Sexo = sexo;
	}



	public List<Birds> getBirds() {
		return birds;
	}



	public void setBirds(List<Birds> birds) {
		this.birds = birds;
	}



	@Override
	public String toString() {
		return "Breeder [id=" + id + ", numCriador=" + numCriador + ", Nombre=" + Nombre + ", apellidos=" + apellidos
				+ ", Fnac=" + Fnac + ", Sexo=" + Sexo + ", birds=" + birds + "]";
	}



	public Breeder(Long id, Integer numCriador, String nombre, String apellidos, LocalDate fnac, String sexo,
			List<Birds> birds) {
		super();
		this.id = id;
		this.numCriador = numCriador;
		Nombre = nombre;
		this.apellidos = apellidos;
		Fnac = fnac;
		Sexo = sexo;
		this.birds = birds;
	}



	public Breeder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
