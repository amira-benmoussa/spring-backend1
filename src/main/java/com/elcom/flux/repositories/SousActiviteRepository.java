package com.elcom.flux.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elcom.flux.entities.Activite;
import com.elcom.flux.entities.SousActivite;

public interface SousActiviteRepository extends JpaRepository<SousActivite,Integer > {

	boolean existsByCodification(String codification);

	boolean existsByCodificationAndId(String codification, Integer id);

	List<SousActivite> findByActivite(Activite activite);

}
