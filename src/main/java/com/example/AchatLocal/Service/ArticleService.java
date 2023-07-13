package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.Article;

public interface ArticleService {
	
	public List<Article> findAll();
	public Article findById(Integer id);
	public void saveArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(Integer id);


}
