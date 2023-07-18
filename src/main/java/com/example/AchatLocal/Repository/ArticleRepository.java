package com.example.AchatLocal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.Article;
import com.example.AchatLocal.Model.Categorie;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	
	List<Article> findAllByCategorieId(Integer id);

}
