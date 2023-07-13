package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.DemandeArticle;

public interface DemandeArticleService {
	
	public List<DemandeArticle> findAll();
	public DemandeArticle findById(Integer id);
	public void saveDemandeArticle(DemandeArticle da);
	public void updateDemandeArticle(DemandeArticle da);
	public void deleteRole(Integer id);


}
