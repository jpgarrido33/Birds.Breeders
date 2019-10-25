package com.Birds.Breeders.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Breeder {

	private Long id;
	private Integer numCriador;
	private String Nombre;
	private String apellidos;
	private String Fnac;
	private String Sexo;
	

	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Birds> birds;
}
