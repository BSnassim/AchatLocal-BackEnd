package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
