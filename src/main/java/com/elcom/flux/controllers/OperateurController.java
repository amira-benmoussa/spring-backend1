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

import com.elcom.flux.entities.Operateur;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.OperateurService;
@CrossOrigin("*")
@RestController
@RequestMapping("/operateurs")
public class OperateurController {
	
	@Autowired
	private OperateurService operateurService;

	@GetMapping
	public List<Operateur> getAllOperateur() {
		return operateurService.findAll();
	}
	
	@GetMapping("/enabled/responsable/{id}")
	public List<Operateur> getEnabledOperateurByResponsable(@PathVariable Integer id) {
		return operateurService.findEnabledByResponsable(id);
	}
	
	@GetMapping("/disabled/responsable/{id}")
	public List<Operateur> getDisabledOperateurByResponsable(@PathVariable Integer id) {
		return operateurService.findDisabledByResponsable(id);
	}

	@GetMapping("/enabled")
	public List<Operateur> getEnabled() {
		return operateurService.findEnabled();
	}
	@GetMapping("/disabled")
	public List<Operateur> getDisabled() {
		return operateurService.findDisabled();
	}
	@PostMapping
	public MessageResponse createResponsable(@RequestBody Operateur operateur) {
		return operateurService.save(operateur);
	}

	// get employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Operateur> getOperateurById(@PathVariable Integer id) {

		Operateur operateur = operateurService.findById(id);

		return ResponseEntity.ok(operateur);
	}

	// update employee
	@PutMapping("/{id}")
	public MessageResponse updateOperateur(@PathVariable Integer id, @RequestBody Operateur operateurDetails) {

		return operateurService.update(operateurDetails, id);
	}

	
	@PatchMapping("/{id}")
	public MessageResponse changeEtat(@PathVariable Integer id) {
		return operateurService.changeEtat(id);
	}


}
