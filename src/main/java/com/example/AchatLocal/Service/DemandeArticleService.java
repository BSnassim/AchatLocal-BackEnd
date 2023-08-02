package com.example.AchatLocal.Service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.AchatLocal.Model.DemandeArticle;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

public interface DemandeArticleService {
	
	public List<DemandeArticle> findAll();
	public List<DemandeArticle> findByDemandeur(Integer id);
	public DemandeArticle findById(Integer id);
	public void saveDemandeArticle(DemandeArticle da);
	public void updateDemandeArticle(DemandeArticle da);
	public void deleteDemandeArticle(Integer id);
	public byte[] pdfReport(DemandeArticle da) throws JRException, FileNotFoundException;
	public long countByEtat(String etat);


}
