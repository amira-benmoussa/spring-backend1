package com.elcom.flux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Activite;
import com.elcom.flux.repositories.ActiviteRepository;
import com.elcom.flux.responses.MessageResponse;

@Service
public class ActiviteService {
	@Autowired
	private ActiviteRepository activiteRepository;

	public MessageResponse save(Activite activite) {

		boolean exist = activiteRepository.existsByNom(activite.getNom());

		if (exist) {
			return new MessageResponse(false, "Attention", "Activité existante");
		}

		activiteRepository.save(activite);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse update(Activite activite) {

		boolean exist = activiteRepository.existsByNom(activite.getNom());

		if (exist) {
			return new MessageResponse(false, "Attention", "Activité existante");
		}

		activiteRepository.save(activite);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse delete(Integer id) {

		boolean exist = activiteRepository.existsByIdAndOperateursNotNull(id);

		if (exist) {
			return new MessageResponse(false, "Attention", "Activité associée a un ou plusieurs opérateurs");
		}

		activiteRepository.deleteById(id);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public List<Activite> findAll() {
		return activiteRepository.findAll();
	}
}
