package com.elcom.flux.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elcom.flux.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	boolean existsByNom(String nom);

	Article findOneByNom(String article);

}
