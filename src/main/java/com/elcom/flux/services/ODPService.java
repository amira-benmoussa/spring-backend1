package com.elcom.flux.services;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elcom.flux.entities.ODP;
import com.elcom.flux.repositories.ODPRepository;

import helper.ODPHelper;
import java.util.List;

@Service
public class ODPService {
	  @Autowired
	  ODPRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<ODP> ODPS = ODPHelper.excelToODPS(file.getInputStream());
	      repository.saveAll(ODPS);
    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<ODP> getAllODPS() {
	    return repository.findAll();
	  }

}
