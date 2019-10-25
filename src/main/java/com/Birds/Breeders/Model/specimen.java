package com.Birds.Breeders.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Specimen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Long id;
	private String nombreespecie;
	
	@ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Birds birds;

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

	public Birds getBirds() {
		return birds;
	}

	public void setBirds(Birds birds) {
		this.birds = birds;
	}

	@Override
	public String toString() {
		return "specimen [id=" + id + ", nombreespecie=" + nombreespecie + ", birds=" + birds + "]";
	}

	public Specimen(Long id, String nombreespecie, Birds birds) {
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