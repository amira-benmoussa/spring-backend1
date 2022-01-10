package com.elcom.flux.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elcom.flux.entities.Activite;
import com.elcom.flux.entities.Employee;
import com.elcom.flux.entities.Odp;
import com.elcom.flux.exceptions.RessourceNotFoundException;
import com.elcom.flux.repositories.ODPRepository;
import com.elcom.flux.responses.MessageResponse;

import helper.ODPHelper;

@CrossOrigin
@RestController
@RequestMapping("/api/excel")
public class ODPController {

	@Autowired
	private ODPRepository odpRepository;
//	 ODPService fileService;
	
	@PostMapping("/odp")
	public Odp createODP(@RequestBody Odp odp) {
		return odpRepository.save(odp);
	}
	
	@GetMapping("odp")
	public List<Odp> getAllEmployees(){
		return odpRepository.findAll();
	}
	
	@DeleteMapping("/odp/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteOdp(@PathVariable Integer id){
		Odp odp = odpRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("matricule inexistane"+id));
		odpRepository.delete(odp);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	

//	  @PostMapping("/upload")
//	  public ResponseEntity<MessageResponse> uploadFile(@RequestPart("file") MultipartFile file) {
//	    String message = "";
//
//	    if (ODPHelper.hasExcelFormat(file)) {
//	      try {
//		      List<ODP> ODPS = ODPHelper.excelToODPS(file.getInputStream());
//	    	  odpRepository.saveAll(ODPS);
//
//	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
//	        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
//	      } catch (Exception e) {
//	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
//	      }
//	    }
//
//	    message = "Please upload an excel file!";
//	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(message));
//	  }


//		@GetMapping("/test")
//		public ResponseEntity<String> getEmployeeById() {
//		
//		    return ResponseEntity.ok("test");
//		}
}
