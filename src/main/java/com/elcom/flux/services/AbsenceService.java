package com.elcom.flux.services;

import com.elcom.flux.entities.Absence;
import com.elcom.flux.entities.Operateur;
import com.elcom.flux.repositories.AbsenceRepository;
import com.elcom.flux.repositories.OperateurRepository;
import com.elcom.flux.requests.AbsenceRequest;
import com.elcom.flux.responses.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private OperateurRepository operateurRepository;

    public MessageResponse save(List<AbsenceRequest> absenceRequests) {


        for (AbsenceRequest abs : absenceRequests) {

            Operateur operateur = operateurRepository.findOneByMatricule(abs.getMatricule());

            if (operateur != null) {

                Absence absence = new Absence();
                absence.setOperateur(operateur);
                absence.setDate(new Date());
                if (abs.getStatut().equalsIgnoreCase("p")) {
                    absence.setStatut(true);
                }



                boolean exist = absenceRepository.existsByDateAndOperateur(new Date(), operateur);
                if(!exist) {
                    absenceRepository.save(absence);
                }

            }

        }


        return new MessageResponse(true, "Succès", "Opération effectuée");
    }


    public List<Absence> findByResponsable(Integer id) {

        return absenceRepository.findByOperateur_Responsable_Id(id);
    }

}
