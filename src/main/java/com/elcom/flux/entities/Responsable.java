package com.elcom.flux.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

@Entity

@Data
public class Responsable extends Employee implements Serializable {
	
	private String email;

	private String password;

}
