package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.BonDeSortie;
import com.example.AchatLocal.Repository.BonDeSortieRepository;

@Service
public class BonDeSortieServiceImpl implements BonDeSortieService {
	
	@Autowired
	private BonDeSortieRepository repo;

	@Override
	public List<BonDeSortie> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public BonDeSortie findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveBonDeSortie(BonDeSortie bs) {
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
