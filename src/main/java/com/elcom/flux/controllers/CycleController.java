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

import com.elcom.flux.entities.Cycle;
import com.elcom.flux.repositories.CycleRepository;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.CycleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cycles")
public class CycleController {
	@Autowired
	private CycleService cycleService;

	@GetMapping
	public List<Cycle> getAllCycle() {
		return cycleService.findAll();
	}

	@PostMapping
	public MessageResponse createCycle(@RequestBody Cycle cycle) {
		return cycleService.save(cycle);
	}

	@PutMapping
	public MessageResponse update(@RequestBody Cycle cycle) {
		return cycleService.update(cycle);
	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return cycleService.delete(id);
	}

}
