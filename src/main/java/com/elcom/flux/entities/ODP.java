package com.elcom.flux.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Data
public class ODP {
	@Id
	@Column(name= "id")
	private Integer id;
	@Column(name= "article")
	private String article;
	@Column(name= "quantite")
	private String quantite;
	
	

	

}
