package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AchatLocal.Model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
