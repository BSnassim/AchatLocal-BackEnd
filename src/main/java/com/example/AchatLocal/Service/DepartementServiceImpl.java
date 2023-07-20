package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.Departement;
import com.example.AchatLocal.Repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	private DepartementRepository repo;

	@Override
	public List<Departement> findAll() {
		return (repo.findAll() != null) ? repo.findAll() : null;
	}

	@Override
	public Departement findById(Integer id) {
		return (repo.findById(id).isPresent()) ? repo.findById(id).get() : null;
	}

	@Override
	public void saveDepartement(Departement departement) {
		repo.save(departement);
	}

	@Override
	public void updateDepartement(Departement departement) {
		repo.save(departement);
	}

	@Override
	public void deleteDepartement(Integer id) {
		repo.deleteById(id);
	}

}
