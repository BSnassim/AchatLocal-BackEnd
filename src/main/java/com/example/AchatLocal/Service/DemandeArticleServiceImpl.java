package com.example.AchatLocal.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.AchatLocal.Model.BonDeCommande;
import com.example.AchatLocal.Model.BonDeSortie;
import com.example.AchatLocal.Model.DemandeAchat;
import com.example.AchatLocal.Model.DemandeArticle;
import com.example.AchatLocal.Repository.DemandeArticleRepository;
import com.nimbusds.oauth2.sdk.Response;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class DemandeArticleServiceImpl implements DemandeArticleService {
	
	@Autowired
	private DemandeArticleRepository repo;

	@Override
	public List<DemandeArticle> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public DemandeArticle findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveDemandeArticle(DemandeArticle da) {
		repo.save(da);
	}

	@Override
	public void updateDemandeArticle(DemandeArticle da) {
		repo.save(da);
	}

	@Override
	public void deleteDemandeArticle(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public byte[] pdfReport(DemandeArticle da) throws JRException, FileNotFoundException {
		File file = ResourceUtils.getFile("classpath:demandeArticle.jrxml");
        JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
        
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dateDemande",da.getDateDa().toString());
		parameters.put("idDemande", da.getId().toString());
		parameters.put("demandeur", da.getDemandeur().getDepartement().getNom());
		parameters.put("categorie", (da.getArticle() == null? da.getExtraCategorie() : da.getArticle().getCategorie().getLibelle()));
		parameters.put("idArticle", ( da.getArticle()== null? null :da.getArticle().getId().toString()));
		parameters.put("libelleArticle", ( da.getArticle()== null? da.getExtraArticle() :da.getArticle().getLibelle()));
		parameters.put("quantite", da.getQuantite().toString());
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,new JREmptyDataSource());
		byte[] pdfData = JasperExportManager.exportReportToPdf(jasperPrint);
		
		return pdfData;
	}


}
