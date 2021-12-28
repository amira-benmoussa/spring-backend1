package com.elcom.flux.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.flux.entities.Operateur;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Integer> {

}
