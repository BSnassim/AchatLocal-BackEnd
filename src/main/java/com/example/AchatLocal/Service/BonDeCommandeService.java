package com.example.AchatLocal.Service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.AchatLocal.Model.BonDeCommande;

import net.sf.jasperreports.engine.JRException;

public interface BonDeCommandeService {
	
	public List<BonDeCommande> findAll();
	public BonDeCommande findById(Integer id);
	public void saveBonDeCommande(BonDeCommande bc);
	public void updateBonDeCommande(BonDeCommande bc);
	public void deleteBonDeCommande(Integer id);
	public byte[] pdfReport(BonDeCommande bc) throws JRException, FileNotFoundException;
	public long countAll();


}
