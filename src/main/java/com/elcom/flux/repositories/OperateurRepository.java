package com.elcom.flux.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.flux.entities.Operateur;
import com.elcom.flux.entities.Responsable;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Integer> {

	List<Operateur> findByEnabled(boolean b);

	List<Operateur> findByResponsable(Responsable responsable);

	List<Operateur> findByEnabledAndResponsable(boolean b, Responsable responsable);

}
