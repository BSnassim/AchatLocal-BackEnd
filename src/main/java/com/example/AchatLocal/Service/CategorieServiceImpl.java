package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.AchatLocal.Model.Categorie;
import com.example.AchatLocal.Repository.CategorieRepository;

public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	private CategorieRepository repo;

	@Override
	public List<Categorie> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Categorie findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveCategorie(Categorie categorie) {
		repo.save(categorie);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		repo.save(categorie);
	}

	@Override
	public void deleteCategorie(Integer id) {
		repo.deleteById(id);
	}

}
