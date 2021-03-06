package com.elcom.flux.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;
	
	@ManyToOne
	private Cycle cycle;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
	private List<Odp> odp;
	
}
