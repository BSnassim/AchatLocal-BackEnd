package com.example.AchatLocal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.HistoriqueArticle;

@Repository
public interface HistoriqueArticleRepository extends JpaRepository<HistoriqueArticle, Integer> {
	
	List<HistoriqueArticle> findAllByArticleId(Integer id);

}
