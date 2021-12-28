package com.elcom.flux.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.entities.Activite;
import com.elcom.flux.repositories.ActiviteRepository;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ActiviteController {
	@Autowired
	private ActiviteRepository activiteRepository;

	
	@GetMapping("activite")
	public List<Activite> getAllActivite(){
		return activiteRepository.findAll();
	}
	
	@PostMapping("/activite")
	public Activite createActivite(@RequestBody Activite activite) {
		return activiteRepository.save(activite);
	}

}
