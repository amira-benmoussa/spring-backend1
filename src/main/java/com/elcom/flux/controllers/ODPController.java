package com.elcom.flux.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.entities.Odp;
import com.elcom.flux.requests.OdpRequest;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.ODPService;

@CrossOrigin
@RestController
@RequestMapping("/odps")
public class ODPController {

	@Autowired
	private ODPService odpService;
//	 ODPService fileService;

	@PostMapping
	public MessageResponse upload(@RequestBody List<OdpRequest> odpRequests) {
		return odpService.uploadOdp(odpRequests);
	}

	@GetMapping("/notProd")
	public List<Odp> findOdpNotProd() {
		return odpService.findOdpsNotProd();
	}

	@PutMapping
	public MessageResponse update(@RequestBody Odp odp) {
		return odpService.update(odp);
	}

}
