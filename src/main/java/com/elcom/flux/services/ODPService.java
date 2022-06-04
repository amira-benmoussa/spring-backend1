package com.elcom.flux.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elcom.flux.entities.Article;
import com.elcom.flux.entities.Cycle;
import com.elcom.flux.entities.Odp;
import com.elcom.flux.repositories.ArticleRepository;
import com.elcom.flux.repositories.CycleRepository;
import com.elcom.flux.repositories.ODPRepository;
import com.elcom.flux.requests.OdpRequest;
import com.elcom.flux.responses.MessageResponse;

@Service
public class ODPService {
	@Autowired
	private ODPRepository odpRepository;
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CycleRepository cycleRepository;

	@Transactional
	public MessageResponse uploadOdp(List<OdpRequest> odpRequests) {

		for (OdpRequest odpReq : odpRequests) {

			Odp odp = odpRepository.findById(odpReq.getNumero()).orElse(null);
			if (odp == null) {

				Article article = articleRepository.findOneByNom(odpReq.getArticle());

				if (article == null) {
					article = new Article();
					article.setNom(odpReq.getArticle());

					Cycle cycle = cycleRepository.findOneByNom("STD0");

//				if(cycle==null) {
//					// traitemenet
//				}

					article.setCycle(cycle);
					article = articleRepository.save(article);

				}

				odp = new Odp();
				odp.setNumero(odpReq.getNumero());
				odp.setArticle(article);
				odp.setQuantite(odpReq.getQuantite());
				odp.setCommentaire(odpReq.getCommentaire());
				odp.setDateCreation(new Date());
				odp.setEtat("En attente");
				odp.setUrgence(4);
				odpRepository.save(odp);
			}

		}

		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public List<Odp> findOdpsNotProd() {
		//return odpRepository.findByEtatNotOrderByDateCreationDesc("Production");
		return odpRepository.findAll();
	}

	public MessageResponse update(Odp odp) {
		odpRepository.save(odp);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

    public MessageResponse delete(String id) {

		odpRepository.deleteById(id);
		return new MessageResponse(true, "Succès", "Opération effectuée");
    }
}
