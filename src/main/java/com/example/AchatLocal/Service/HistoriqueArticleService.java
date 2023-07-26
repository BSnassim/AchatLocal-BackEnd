package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.HistoriqueArticle;

public interface HistoriqueArticleService {
	
	List<HistoriqueArticle> findAll();
	List<HistoriqueArticle> findAllByArticle(Integer id);
	HistoriqueArticle findById(Integer id);
	void saveHistorique(HistoriqueArticle h);
	void updateHistorique(HistoriqueArticle h);
	void deleteById(Integer id);

}
