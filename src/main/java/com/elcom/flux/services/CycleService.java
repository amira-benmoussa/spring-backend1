package com.elcom.flux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Cycle;
import com.elcom.flux.repositories.CycleRepository;
import com.elcom.flux.responses.MessageResponse;

@Service
public class CycleService {
	@Autowired
	private CycleRepository cycleRepository;

	public MessageResponse save(Cycle cycle) {

		boolean exist = cycleRepository.existsByNom(cycle.getNom());

		if (exist) {
			return new MessageResponse(false, "Attention", "Nom existante");
		}

		cycleRepository.save(cycle);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse update(Cycle cycle) {

		boolean exist = cycleRepository.existsByNomAndId(cycle.getNom(), cycle.getId());
		if (!exist) {
			exist = cycleRepository.existsByNom(cycle.getNom());
			if (exist) {
				return new MessageResponse(false, "Attention", "Activité existante");
			}
		}
		cycleRepository.save(cycle);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse delete(Integer id) {

		boolean exist = cycleRepository.existsByIdAndArticlesNotNull(id);

		if (exist) {
			return new MessageResponse(false, "Attention", "Activité associée a un ou plusieurs sous activités");
		}

		cycleRepository.deleteById(id);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public List<Cycle> findAll() {
		return cycleRepository.findAll();
	}

}
