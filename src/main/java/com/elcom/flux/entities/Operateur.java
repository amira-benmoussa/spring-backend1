package com.elcom.flux.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Operateur extends Employee implements Serializable {

	@ManyToOne
	private Responsable responsable;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "operateur_sous_activites", joinColumns = { 
			@JoinColumn(name = "operateurs_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "sous_activites_id", 
					nullable = false, updatable = false) })
	private List<SousActivite> sousActivites;

}
