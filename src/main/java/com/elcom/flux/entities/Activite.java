package com.elcom.flux.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data

public class Activite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@JsonIgnore
	@OneToMany(mappedBy = "activite")
	private List<Operateur> operateurs;

	
	@JsonIgnore
	@OneToMany(mappedBy = "activite", cascade = CascadeType.REMOVE)
	private List<SousActivite> sousActivites;
}
