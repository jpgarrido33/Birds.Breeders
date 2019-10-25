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
public class specimen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@Column(unique = true)
	private Long id;
	private String nombreespecie;
	
	@ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Birds birds;
}