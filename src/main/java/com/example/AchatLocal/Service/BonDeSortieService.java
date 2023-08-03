package com.example.AchatLocal.Service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.AchatLocal.Model.BonDeSortie;

import net.sf.jasperreports.engine.JRException;

public interface BonDeSortieService {
	
	public List<BonDeSortie> findAll();
	public BonDeSortie findById(Integer id);
	public void saveBonDeSortie(BonDeSortie bs);
	public void updateBonDeSortie(BonDeSortie bs);
	public void deleteBonDeSortie(Integer id);
	public byte[] pdfReport(BonDeSortie bs) throws JRException, FileNotFoundException;
	public long countAll();


}
