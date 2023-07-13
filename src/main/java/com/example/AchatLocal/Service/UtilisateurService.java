package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.Utilisateur;

public interface UtilisateurService {
	
	public List<Utilisateur> findAll();
	public Utilisateur findById(Integer id);
	public Utilisateur findByEmail(String email);
	public void saveUtilisateur(Utilisateur user);
	public void updateUtilisateur(Utilisateur user);
	public void deleteUtilisateur(Integer id);
}
