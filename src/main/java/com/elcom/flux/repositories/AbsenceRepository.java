package com.elcom.flux.repositories;

import com.elcom.flux.entities.Absence;
import com.elcom.flux.entities.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {


    public List<Absence> findByOperateur_Responsable_Id(Integer id);

    boolean existsByDateAndOperateur(Date date, Operateur operateur);
}
