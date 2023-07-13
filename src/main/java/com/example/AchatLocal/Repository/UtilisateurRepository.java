package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AchatLocal.Model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	
	Utilisateur findByEmail(String email);

}
