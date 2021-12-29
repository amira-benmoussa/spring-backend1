package com.elcom.flux.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.entities.Responsable;
import com.elcom.flux.exceptions.RessourceNotFoundException;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.ResponsableService;

@CrossOrigin("*")
@RestController
@RequestMapping("/responsables")
public class ResponsableController {
	@Autowired
	private ResponsableService responsableService;

	@GetMapping
	public List<Responsable> getAllResponsable() {
		return responsableService.findAll();
	}

	@PostMapping
	public MessageResponse createResponsable(@RequestBody Responsable responsable) {
		return responsableService.save(responsable);
	}

	// get employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Responsable> getResponsableById(@PathVariable Integer id) {

		Responsable responsable = responsableService.findById(id);

		return ResponseEntity.ok(responsable);
	}

	// update employee
	@PutMapping("/{id}")
	public MessageResponse updateResponsable(@PathVariable Integer id, @RequestBody Responsable responsableDetails) {

		return responsableService.update(responsableDetails, id);
	}

	
	@PatchMapping("/{id}")
	public MessageResponse changeEtat(@PathVariable Integer id) {
		return responsableService.changeEtat(id);
	}

}
