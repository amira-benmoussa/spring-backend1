package com.elcom.flux.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Operateur;
import com.elcom.flux.entities.Responsable;
import com.elcom.flux.entities.SousActivite;
import com.elcom.flux.repositories.EmployeeRepository;
import com.elcom.flux.repositories.OperateurRepository;
import com.elcom.flux.repositories.SousActiviteRepository;
import com.elcom.flux.responses.MessageResponse;

@Service
public class OperateurService {

	@Autowired
	private OperateurRepository operateurRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private SousActiviteRepository sousActiviteRepository;

	@Transactional
	public MessageResponse save(Operateur operateur) {

		boolean exist = employeeRepository.existsByMatricule(operateur.getMatricule());
		if (exist) {
			return new MessageResponse(false, "Attention", "Matricule existe déjà");
		}
//		List<Operateur> op = new ArrayList<>();
//		op.add(operateur);
//
//	List<SousActivite> sousActivities =	operateur.getSousActivites().stream().map(s -> {
//			s.setOperateurs(op);
//			return s;
//		}).collect(Collectors.toList());

		List<Integer> ids = operateur.getSousActivites().stream().map(s -> {

			return s.getId();
		}).collect(Collectors.toList());
		List<SousActivite> sousActivities = sousActiviteRepository.findAllById(ids);
		operateur.setSousActivites(sousActivities);
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
	
	
	public List<Operateur> findByResponsable(Integer id) {
		Responsable responsable = new Responsable();
		responsable.setId(id);
		return operateurRepository.findByResponsable(responsable);
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

	public List<Operateur> findEnabled() {
		return operateurRepository.findByEnabled(true);
	}

	public List<Operateur> findDisabled() {
		return operateurRepository.findByEnabled(false);
	}
	
	
	public List<Operateur> findEnabledByResponsable(Integer id) {
		Responsable responsable = new Responsable();
		responsable.setId(id);
		return operateurRepository.findByEnabledAndResponsable(true, responsable);
	}

	public List<Operateur> findDisabledByResponsable(Integer id) {
		Responsable responsable = new Responsable();
		responsable.setId(id);
		return operateurRepository.findByEnabledAndResponsable(false, responsable);
	}

}
