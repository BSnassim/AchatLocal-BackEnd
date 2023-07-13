package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.DemandeArticle;

@Repository
public interface DemandeArticleRepository extends JpaRepository<DemandeArticle, Integer>{

}
