package com.elcom.flux.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.flux.entities.Odp;

@Repository
public interface ODPRepository extends JpaRepository<Odp,String> {
	
	
	public List<Odp> findByEtatNotOrderByDateCreationDesc(String etat);

}
