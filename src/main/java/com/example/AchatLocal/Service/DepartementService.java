package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.Departement;

public interface DepartementService {
	
	public List<Departement> findAll();
	public Departement findById(Integer id);
	public void saveDepartement(Departement departement);
	public void updateDepartement(Departement departement);
	public void deleteDepartement(Integer id);

}
