package com.elcom.flux.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.entities.Article;
import com.elcom.flux.repositories.ArticleRepository;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.ArticleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/articles")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@GetMapping
	public List<Article> getAllArticle() {
		return articleService.findAll();
	}

	@PostMapping
	public MessageResponse createArticle(@RequestBody Article article) {
		return articleService.save(article);
	}

	@PutMapping
	public MessageResponse update(@RequestBody Article article) {
		return articleService.update(article);
	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return articleService.delete(id);
	}

}
