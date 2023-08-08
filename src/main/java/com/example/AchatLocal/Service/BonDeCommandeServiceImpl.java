package com.example.AchatLocal.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.AchatLocal.Model.BonDeCommande;
import com.example.AchatLocal.Repository.BonDeCommandeRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class BonDeCommandeServiceImpl implements BonDeCommandeService {
	
	@Autowired
	private BonDeCommandeRepository repo;

	@Override
	public List<BonDeCommande> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public BonDeCommande findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}
	
	@Override
	public byte[] pdfReport(BonDeCommande bc) throws JRException, FileNotFoundException {
		File file = ResourceUtils.getFile("classpath:bonDeCommande.jrxml");
        JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
        String nomM = bc.getDemandeur().getNom()+" "+ bc.getDemandeur().getPrenom();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dateDemande",bc.getDateCommande().toString());
		parameters.put("idDemande", bc.getId().toString());
		parameters.put("magasinier", nomM);
		parameters.put("categorie", (bc.getArticle() == null? bc.getExtraCategorie().getLibelle() : bc.getArticle().getCategorie().getLibelle()));
		parameters.put("idArticle", ( bc.getArticle()== null? "N/A" :bc.getArticle().getId().toString()));
		parameters.put("libelleArticle", ( bc.getArticle()== null? bc.getExtraArticle() :bc.getArticle().getLibelle()));
		parameters.put("quantite", bc.getQuantite().toString());
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,new JREmptyDataSource());
		byte[] pdfData = JasperExportManager.exportReportToPdf(jasperPrint);
		
		return pdfData;
	}


	@Override
	public void saveBonDeCommande(BonDeCommande bc) {
		repo.save(bc);
	}

	@Override
	public void updateBonDeCommande(BonDeCommande bc) {
		repo.save(bc);
	}

	@Override
	public void deleteBonDeCommande(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public long countAll() {
		return repo.count();
	}

}
