package com.example.AchatLocal.Endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/")
	public List<Article> findAllArticles(){
		return serv.findAll();
	}

}
