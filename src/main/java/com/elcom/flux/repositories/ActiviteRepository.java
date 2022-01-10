package com.elcom.flux.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.flux.entities.Activite;
import com.elcom.flux.entities.Odp;



@Repository
public interface ActiviteRepository extends JpaRepository<Activite,Integer > {

	boolean existsByNom(String nom);

	boolean existsByIdAndSousActivitesNotNull(Integer id);



}
