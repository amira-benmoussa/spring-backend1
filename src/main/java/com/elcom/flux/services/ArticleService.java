package com.elcom.flux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Article;
import com.elcom.flux.repositories.ArticleRepository;
import com.elcom.flux.responses.MessageResponse;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	public MessageResponse save(Article article) {

		boolean exist = articleRepository.existsByNom(article.getNom());

		if (exist) {
			return new MessageResponse(false, "Attention", "Article existant");
		}

		articleRepository.save(article);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse update(Article article) {



		articleRepository.save(article);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public MessageResponse delete(Integer id) {

//		boolean exist = articleRepository.existsByIdAndSousArticlesNotNull(id);
//
//		if (exist) {
//			return new MessageResponse(false, "Attention", "Activité associée a un ou plusieurs sous activités");
//		}

		articleRepository.deleteById(id);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	public List<Article> findAll() {
		return articleRepository.findAll();
	}
}
