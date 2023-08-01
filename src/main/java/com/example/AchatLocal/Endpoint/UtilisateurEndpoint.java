package com.example.AchatLocal.Endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AchatLocal.Model.Utilisateur;
import com.example.AchatLocal.Service.UtilisateurService;

@RequestMapping("/users")
@CrossOrigin
@RestController
public class UtilisateurEndpoint {
	
	@Autowired
	private UtilisateurService serv;

	@GetMapping("")
	public List<Utilisateur> findAllUtilisateurs() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public Utilisateur findUtilisateurById(@PathVariable Integer id) {
		return serv.findById(id);
	}
	
	@GetMapping("/email/{mail}")
	public Utilisateur findUtilisateurByEmail(@PathVariable String mail) {
		return serv.findByEmail(mail);
	}

	@PostMapping("")
	public void saveUtilisateur(@RequestBody Utilisateur role) {
		serv.saveUtilisateur(role);
	}
	
	@PutMapping("")
	public void updateUtilisateur(@RequestBody Utilisateur role) {
		serv.updateUtilisateur(role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUtilisateur(@PathVariable Integer id) {
		serv.deleteUtilisateur(id);
	}
	
	@GetMapping("/count")
	public long countUsers() {
		return serv.countUsers();
	}
	
	@GetMapping("/count/{role}")
	public long countUsersByRole(@PathVariable String role) {
		return serv.countUsersByRole(role);
	}
	
	@GetMapping("/count/departement/{departement}")
	public long countUsersByDepartement(@PathVariable String departement) {
		return serv.countUsersByDepartement(departement);
	}

}
