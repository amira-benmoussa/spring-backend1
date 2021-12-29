package com.elcom.flux.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity

@Data
public class Responsable extends Employee implements Serializable {

	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	

}
