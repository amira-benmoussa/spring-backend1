package com.elcom.flux.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elcom.flux.entities.Cycle;

public interface CycleRepository  extends JpaRepository<Cycle, Integer>{

	boolean existsByNom(String nom);

	boolean existsByNomAndId(String nom, Integer id);

	boolean existsByIdAndArticlesNotNull(Integer id);

	

}
