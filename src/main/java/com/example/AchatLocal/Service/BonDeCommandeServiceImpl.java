package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.BonDeCommande;
import com.example.AchatLocal.Repository.BonDeCommandeRepository;

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

}
