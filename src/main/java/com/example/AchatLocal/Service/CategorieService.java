package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.Categorie;

public interface CategorieService {
	
	public List<Categorie> findAll();
	public List<Categorie> findAllByType(String type);
	public Categorie findById(Integer id);
	public void saveCategorie(Categorie categorie);
	public void updateCategorie(Categorie categorie);
	public void deleteCategorie(Integer id);


}
