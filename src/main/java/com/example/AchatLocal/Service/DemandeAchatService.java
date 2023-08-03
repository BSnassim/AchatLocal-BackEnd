package com.example.AchatLocal.Service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.AchatLocal.Model.DemandeAchat;
import com.example.AchatLocal.Model.DemandeArticle;

import net.sf.jasperreports.engine.JRException;

public interface DemandeAchatService {
	
	public List<DemandeAchat> findAll();
	public DemandeAchat findById(Integer id);
	public void saveDemandeAchat(DemandeAchat da);
	public void updateDemandeAchat(DemandeAchat da);
	public void deleteDemandeAchat(Integer id);
	public byte[] pdfReport(DemandeAchat da) throws JRException, FileNotFoundException;
	public long countAll();

}
