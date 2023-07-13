package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.BonDeSortie;

public interface BonDeSortieService {
	
	public List<BonDeSortie> findAll();
	public BonDeSortie findById(Integer id);
	public void saveBonDeSortie(BonDeSortie bs);
	public void updateBonDeSortie(BonDeSortie bs);
	public void deleteBonDeSortie(Integer id);


}
