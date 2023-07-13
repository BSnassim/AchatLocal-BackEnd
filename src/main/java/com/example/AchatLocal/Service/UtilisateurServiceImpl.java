package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.Utilisateur;
import com.example.AchatLocal.Repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private UtilisateurRepository repo;

	@Override
	public List<Utilisateur> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Utilisateur findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null ;
	}

	@Override
	public Utilisateur findByEmail(String email) {
		return (repo.findByEmail(email) != null)? repo.findByEmail(email) : null;
	}

	@Override
	public void saveUtilisateur(Utilisateur user) {
		repo.save(user);
		
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		repo.save(user);
		
	}

	@Override
	public void deleteUtilisateur(Integer id) {
		repo.deleteById(id);
		
	}

}
