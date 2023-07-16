package com.example.AchatLocal.Endpoint;

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

import com.example.AchatLocal.Model.Article;
import com.example.AchatLocal.Service.ArticleService;

@RequestMapping("/articles")
@CrossOrigin
@RestController
public class ArticleEndpoint {
	
	@Autowired
	private ArticleService serv;

	@GetMapping("")
	public List<Article> findAllArticles() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public Article findArticleById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveArticle(@RequestBody Article role) {
		serv.saveArticle(role);
	}
	
	@PutMapping("")
	public void updateArticle(@RequestBody Article role) {
		serv.updateArticle(role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteArticle(@PathVariable Integer id) {
		serv.deleteArticle(id);
	}

}
