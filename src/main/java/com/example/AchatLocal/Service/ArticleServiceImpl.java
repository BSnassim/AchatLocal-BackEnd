package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.Article;
import com.example.AchatLocal.Repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository repo;

	@Override
	public List<Article> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Article findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveArticle(Article article) {
		repo.save(article);
	}

	@Override
	public void updateArticle(Article article) {
		repo.save(article);
	}

	@Override
	public void deleteArticle(Integer id) {
		repo.deleteById(id);
	}

}
