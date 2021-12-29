package com.elcom.flux.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity

@Data
public class Responsable extends Employee implements Serializable {

	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@JsonIgnore
	@OneToMany(mappedBy = "responsable")
	private List<Operateur> operateurs;
	

}
