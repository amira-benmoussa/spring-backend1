package com.elcom.flux.requests;

import lombok.Data;

@Data
public class OdpRequest {

	private String numero;
	private String article;
	private int quantite;
	private String commentaire;
}
