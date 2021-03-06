package com.elcom.flux.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.entities.Activite;
import com.elcom.flux.repositories.ActiviteRepository;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.ActiviteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/activites")
public class ActiviteController {
	@Autowired
	private ActiviteService activiteService;

	@GetMapping
	public List<Activite> getAllActivite() {
		return activiteService.findAll();
	}

	@PostMapping
	public MessageResponse createActivite(@RequestBody Activite activite) {
		return activiteService.save(activite);
	}

	@PutMapping
	public MessageResponse update(@RequestBody Activite activite) {
		return activiteService.update(activite);
	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return activiteService.delete(id);
	}

}
