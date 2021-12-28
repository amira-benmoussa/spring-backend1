package com.elcom.flux.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.entities.SousActivite;
import com.elcom.flux.repositories.Sous_activiteRepository;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")

public class SousactiviteController {
	
	@Autowired
	private Sous_activiteRepository Sous_activiteRepository;

	
	@GetMapping("sous_activite")
	public List<SousActivite> getAllActivite(){
		return Sous_activiteRepository.findAll();
	}
	
	@PostMapping("/sous_activite")
	public SousActivite createActivite(@RequestBody SousActivite activite) {
		return Sous_activiteRepository.save(activite);
	}


}
