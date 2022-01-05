package com.elcom.flux.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "sous_activites")
@Data
public class SousActivite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codification;
	private String nom;
	@ManyToOne
	private Activite activite;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "sousActivites")
	private List<Operateur> operateurs;

}
