package com.elcom.flux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Activite;
import com.elcom.flux.entities.SousActivite;
import com.elcom.flux.repositories.SousActiviteRepository;
import com.elcom.flux.responses.MessageResponse;

@Service
public class SousActiviteService {
	@Autowired
	private SousActiviteRepository sousActiviteRepository;

	public MessageResponse save(SousActivite sousActivite) {

		boolean exist = sousActiviteRepository.existsByCodification(sousActivite.getCodification());

		if (exist) {
			return new MessageResponse(false, "Attention", "Activité existante");
		}

		sousActiviteRepository.save(sousActivite);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse update(SousActivite sousActivite) {

		boolean exist = sousActiviteRepository.existsByCodificationAndId(sousActivite.getCodification(),
				sousActivite.getId());

		if (!exist) {
			exist = sousActiviteRepository.existsByCodification(sousActivite.getCodification());

			if (exist) {
				return new MessageResponse(false, "Attention", "Activité existante");
			}
		}

		sousActiviteRepository.save(sousActivite);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse delete(Integer id) {

		sousActiviteRepository.deleteById(id);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public List<SousActivite> findByActivite(Integer id) {
		Activite activite = new Activite();
		activite.setId(id);
		return sousActiviteRepository.findByActivite(activite);
	}
	public List<SousActivite> findAll() {
		return sousActiviteRepository.findAll();
	}

}
