package com.elcom.flux.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Odp {
	@Id
	private String numero;
	private Date dateCreation;
	private Integer quantite;
	private String etat;
	@Lob
	private String commentaire;
	private int urgence;
	@ManyToOne
	private Article article;
	
	

	

}
