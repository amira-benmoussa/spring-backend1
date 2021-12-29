package com.elcom.flux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Operateur;
import com.elcom.flux.repositories.EmployeeRepository;
import com.elcom.flux.repositories.OperateurRepository;
import com.elcom.flux.responses.MessageResponse;

@Service
public class OperateurService {

	@Autowired
	private OperateurRepository operateurRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public MessageResponse save(Operateur operateur) {

		boolean exist = employeeRepository.existsByMatricule(operateur.getMatricule());
		if (exist) {
			return new MessageResponse(false, "Attention", "Matricule existe déjà");
		}
		operateur.setEnabled(true);
		operateurRepository.save(operateur);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse update(Operateur operateur, Integer id) {

		Operateur resp = findById(id);
		if (id == null) {
			return new MessageResponse(false, "Attention", "Operateur n'existe pas");
		}
		boolean exist = employeeRepository.existsByMatriculeAndId(operateur.getMatricule(), id);
		if (!exist) {
			exist = employeeRepository.existsByMatricule(operateur.getMatricule());
			if (exist) {
				return new MessageResponse(false, "Attention", "Matricule existe déjà");
			}
		}

		operateurRepository.save(operateur);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public List<Operateur> findAll() {
		// TODO Auto-generated method stub
		return operateurRepository.findAll();
	}

	public Operateur findById(Integer id) {
		// TODO Auto-generated method stub
		return operateurRepository.findById(id).orElse(null);
	}

	public MessageResponse changeEtat(Integer id) {
		Operateur Operateur = findById(id);
		if (id == null) {
			return new MessageResponse(false, "Attention", "Operateur n'existe pas");
		}
		Operateur.setEnabled(!Operateur.isEnabled());
		operateurRepository.save(Operateur);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

}
