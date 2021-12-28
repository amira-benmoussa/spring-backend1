package com.elcom.flux.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.flux.entities.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {

}
