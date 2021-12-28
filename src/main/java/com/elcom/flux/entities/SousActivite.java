package com.elcom.flux.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "sous_activites")
@Data
public class SousActivite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column(name = "codification")
	private String codification;
	@Column(name = "nom")
	private String nom;
	@Column(name = "famille")
	private String famille;

}
