package com.elcom.flux.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.flux.entities.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {

	boolean existsByEmail(String email);

	boolean existsByEmailAndId(String email, Integer id);

	List<Responsable> findByEnabledAndPosteNot(boolean b, String string);

}
