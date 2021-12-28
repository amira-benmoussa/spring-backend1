package com.elcom.flux.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.entities.Employee;
import com.elcom.flux.entities.Responsable;
import com.elcom.flux.exceptions.RessourceNotFoundException;
import com.elcom.flux.repositories.EmployeeRepository;
import com.elcom.flux.repositories.ResponsableRepository;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ResponsableController {
	@Autowired
	private ResponsableRepository responsableRepository;

	
	@GetMapping("responsable")
	public List<Responsable> getAllResponsable(){
		return responsableRepository.findAll();
	}
	
	@PostMapping("/responsable")
	public Responsable createResponsable(@RequestBody Responsable responsable) {
		return responsableRepository.save(responsable);
	}
	
	//get employee by id
		@GetMapping("/responsable/{id}")
		public ResponseEntity<Responsable> getResponsableById(@PathVariable(name="id") Integer id) {
		
			Responsable responsable = responsableRepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("matricule inexistane"+id));
		    return ResponseEntity.ok(responsable);
		}
	
	//update employee
		@PutMapping("/responsable/{id}")
		
		public ResponseEntity<Responsable> updateResponsable(@PathVariable Integer id,@RequestBody Responsable responsableDetails){

			Responsable responsable = responsableRepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("matricule inexistane"+id));
			
			responsable.setNom(responsableDetails.getNom());
			responsable.setPrenom(responsableDetails.getPrenom());
			responsable.setEmail(responsableDetails.getEmail());
			responsable.setTel(responsableDetails.getTel());
			Responsable updatedResponsable = responsableRepository.save(responsable);
			return ResponseEntity.ok(updatedResponsable);
		}
	
	@DeleteMapping("/responsable/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteResponsable(@PathVariable Integer id){
		Responsable responsable = responsableRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("matricule inexistane"+id));
		responsableRepository.delete(responsable);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
} 	
