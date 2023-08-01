package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Config.PasswordEncoderCreation;
import com.example.AchatLocal.Model.Utilisateur;
import com.example.AchatLocal.Repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private UtilisateurRepository repo;
	
	@Autowired
	private PasswordEncoderCreation pwEN;

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
		return (repo.findByEmail(email).isPresent())? repo.findByEmail(email).get() : null ;
	}

	@Override
	public void saveUtilisateur(Utilisateur user) {
		user.setPassword(pwEN.myPasswordEncoder().encode(user.getPassword()));
		repo.save(user);
		
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		user.setPassword(pwEN.myPasswordEncoder().encode(user.getPassword()));
		repo.save(user);
		
	}

	@Override
	public void deleteUtilisateur(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public long countUsersByRole(String role) {
		return repo.countByRole(role);
	}
	
	@Override
	public long countUsers() {
		return repo.count();
	}

	@Override
	public long countUsersByDepartement(String departement) {
		return repo.countByDepartementNom(departement);
	}

}
