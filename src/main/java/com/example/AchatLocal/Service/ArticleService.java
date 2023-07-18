package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.Article;
import com.example.AchatLocal.Model.Categorie;

public interface ArticleService {
	
	public List<Article> findAll();
	public List<Article> findAllByCategorie(Integer id);
	public Article findById(Integer id);
	public void saveArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(Integer id);


}
