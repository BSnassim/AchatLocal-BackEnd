package com.example.AchatLocal.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.AchatLocal.Model.DemandeAchat;
import com.example.AchatLocal.Repository.DemandeAchatRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class DemandeAchatServiceImpl implements DemandeAchatService {
	
	@Autowired
	private DemandeAchatRepository repo;

	@Override
	public List<DemandeAchat> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public DemandeAchat findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}
	
	@Override
	public byte[] pdfReport(DemandeAchat da) throws JRException, FileNotFoundException {
		File file = ResourceUtils.getFile("classpath:demandeAchat.jrxml");
        JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
        String nomM = da.getMagasinier().getNom()+" "+ da.getMagasinier().getPrenom();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dateDemande",da.getDateAchat().toString());
		parameters.put("idDemande", da.getId().toString());
		parameters.put("magasinier", nomM);
		parameters.put("categorie", (da.getArticle() == null? da.getExtraCategorie().getLibelle() : da.getArticle().getCategorie().getLibelle()));
		parameters.put("idArticle", ( da.getArticle()== null? "N/A" :da.getArticle().getId().toString()));
		parameters.put("libelleArticle", ( da.getArticle()== null? da.getExtraArticle() :da.getArticle().getLibelle()));
		parameters.put("quantite", da.getQuantite().toString());
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,new JREmptyDataSource());
		byte[] pdfData = JasperExportManager.exportReportToPdf(jasperPrint);
		
		return pdfData;
	}

	@Override
	public void saveDemandeAchat(DemandeAchat da) {
		repo.save(da);
	}

	@Override
	public void updateDemandeAchat(DemandeAchat da) {
		repo.save(da);
	}

	@Override
	public void deleteDemandeAchat(Integer id) {
		repo.deleteById(id);
	}

}
