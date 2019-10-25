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
	private LocalDate Sexo;
	

	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Birds> birds= new ArrayList<Birds>();
	
	
}
