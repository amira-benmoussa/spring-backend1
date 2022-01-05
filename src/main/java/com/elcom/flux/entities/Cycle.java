package com.elcom.flux.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Cycle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;
	private boolean ligneSimple;
	private boolean ligneUltra;
	private boolean composant;
	private boolean etiquette;
	private boolean tube;
	@JsonIgnore
	@OneToMany(mappedBy = "cycle")
	private List<Article> articles;
}
