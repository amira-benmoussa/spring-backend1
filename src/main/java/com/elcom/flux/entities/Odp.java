package com.elcom.flux.entities;



import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Odp {
	@Id
	private String numero;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private Integer quantite;
	private String etat;
	@Lob
	private String commentaire;
	private int urgence;
	@ManyToOne
	private Article article;
	
	

	

}
