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

import com.elcom.flux.entities.SousActivite;
import com.elcom.flux.repositories.SousActiviteRepository;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.SousActiviteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sousActivites")
public class SousActiviteController {
	@Autowired
	private SousActiviteService sousActiviteService;

	@GetMapping("/activite/{id}")
	public List<SousActivite> getByActivite(@PathVariable Integer id) {
		return sousActiviteService.findByActivite(id);
	}

	@PostMapping
	public MessageResponse createSousActivite(@RequestBody SousActivite sousActivite) {
		return sousActiviteService.save(sousActivite);
	}

	@PutMapping
	public MessageResponse update(@RequestBody SousActivite sousActivite) {
		return sousActiviteService.update(sousActivite);
	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return sousActiviteService.delete(id);
	}

}
