package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.BonDeCommande;

public interface BonDeCommandeService {
	
	public List<BonDeCommande> findAll();
	public BonDeCommande findById(Integer id);
	public void saveBonDeCommande(BonDeCommande bc);
	public void updateBonDeCommande(BonDeCommande bc);
	public void deleteBonDeCommande(Integer id);


}
