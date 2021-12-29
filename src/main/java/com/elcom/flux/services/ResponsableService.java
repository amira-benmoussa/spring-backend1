package com.elcom.flux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Responsable;
import com.elcom.flux.repositories.EmployeeRepository;
import com.elcom.flux.repositories.ResponsableRepository;
import com.elcom.flux.responses.MessageResponse;

@Service
public class ResponsableService {

	@Autowired
	private ResponsableRepository responsableRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public MessageResponse save(Responsable responsable) {

		boolean exist = employeeRepository.existsByMatricule(responsable.getMatricule());
		if (exist) {
			return new MessageResponse(false, "Attention", "Matricule existe déjà");
		}
		exist = responsableRepository.existsByEmail(responsable.getEmail());
		if (exist) {
			return new MessageResponse(false, "Attention", "Email existe déjà");
		}

		String encodedPassword = passwordEncoder.encode(responsable.getPassword());
		responsable.setPassword(encodedPassword);
		responsableRepository.save(responsable);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse update(Responsable responsable, Integer id) {

		Responsable resp = findById(id);
		if (id == null) {
			return new MessageResponse(false, "Attention", "Responsable n'existe pas");
		}
		boolean exist = employeeRepository.existsByMatriculeAndId(responsable.getMatricule(), id);
		if (!exist) {
			exist = employeeRepository.existsByMatricule(responsable.getMatricule());
			if (exist) {
				return new MessageResponse(false, "Attention", "Matricule existe déjà");
			}
		}
		exist = responsableRepository.existsByEmailAndId(responsable.getEmail(), id);
		if (!exist) {
			exist = responsableRepository.existsByEmail(responsable.getEmail());
			if (exist) {
				return new MessageResponse(false, "Attention", "Email existe déjà");
			}
		}

		responsable.setPassword(resp.getPassword());
		responsableRepository.save(responsable);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public List<Responsable> findAll() {
		// TODO Auto-generated method stub
		return responsableRepository.findAll();
	}

	public Responsable findById(Integer id) {
		// TODO Auto-generated method stub
		return responsableRepository.findById(id).orElse(null);
	}

	public MessageResponse changeEtat(Integer id) {
		Responsable responsable = findById(id);
		if (id == null) {
			return new MessageResponse(false, "Attention", "Responsable n'existe pas");
		}
		responsable.setEnabled(!responsable.isEnabled());
		responsableRepository.save(responsable);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

}
