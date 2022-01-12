package com.elcom.flux.responses;

import com.elcom.flux.entities.Responsable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

	private String token;
	private Responsable responsable;

}
