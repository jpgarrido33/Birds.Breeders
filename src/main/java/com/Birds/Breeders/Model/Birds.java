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

@Entity
public class Birds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Long id;
	private LocalDate fNac;
	private String sexo;
	private Integer numAnilla;
	private String especie;
	private String nomCientif;
	private String color;
	
	@OneToMany(mappedBy = "birds")
	private List<specimen> specimen;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Breeder breeder;
	

}
