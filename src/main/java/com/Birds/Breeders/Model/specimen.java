package com.Birds.Breeders.Model;

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

@Entity
public class Specimen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true, updatable = false)
	private Long id;
	@Column
	private String nombreespecie;
	
//	@ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Birds birds;

	@OneToMany(mappedBy="specimen")
	private List<Birds> birds= new ArrayList<Birds>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreespecie() {
		return nombreespecie;
	}

	public void setNombreespecie(String nombreespecie) {
		this.nombreespecie = nombreespecie;
	}



	public List<Birds> getBirds() {
		return birds;
	}

	public void setBirds(List<Birds> birds) {
		this.birds = birds;
	}

	
	public Specimen(Long id, String nombreespecie, List<Birds> birds) {
		super();
		this.id = id;
		this.nombreespecie = nombreespecie;
		this.birds = birds;
	}

	public Specimen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}