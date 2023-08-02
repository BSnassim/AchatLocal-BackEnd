package com.example.AchatLocal.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.AchatLocal.Model.Article;
import com.example.AchatLocal.Model.BonDeSortie;
import com.example.AchatLocal.Repository.BonDeSortieRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class BonDeSortieServiceImpl implements BonDeSortieService {
	
	@Autowired
	private BonDeSortieRepository repo;
	
	@Autowired
	private ArticleService servArticle;
	
	@Autowired
	private DemandeArticleService servDa;

	@Override
	public List<BonDeSortie> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public BonDeSortie findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}
	
	@Override
	public byte[] pdfReport(BonDeSortie bs) throws JRException, FileNotFoundException {
		File file = ResourceUtils.getFile("classpath:bonDeSortie.jrxml");
        JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
        String nomM = bs.getMagasinier().getNom()+" "+ bs.getMagasinier().getPrenom();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dateDemande",bs.getDateSortie().toString());
		parameters.put("idDemande", bs.getId().toString());
		parameters.put("magasinier", nomM);
		parameters.put("categorie", bs.getDemandeArticle().getArticle().getCategorie().getLibelle());
		parameters.put("idArticle", bs.getDemandeArticle().getArticle().getId());
		parameters.put("libelleArticle", bs.getDemandeArticle().getArticle().getLibelle());
		parameters.put("quantite", bs.getDemandeArticle().getQuantite().toString());
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,new JREmptyDataSource());
		byte[] pdfData = JasperExportManager.exportReportToPdf(jasperPrint);
		
		return pdfData;
	}


	@Override
	public void saveBonDeSortie(BonDeSortie bs) {
		Article a = bs.getDemandeArticle().getArticle();
		a.reduceStock(bs.getDemandeArticle().getQuantite());
		servArticle.updateArticle(a);
		bs.getDemandeArticle().setEtat("Terminé");
		servDa.updateDemandeArticle(bs.getDemandeArticle());
		repo.save(bs);
	}

	@Override
	public void updateBonDeSortie(BonDeSortie bs) {
		repo.save(bs);
	}

	@Override
	public void deleteBonDeSortie(Integer id) {
		repo.deleteById(id);
	}

}
