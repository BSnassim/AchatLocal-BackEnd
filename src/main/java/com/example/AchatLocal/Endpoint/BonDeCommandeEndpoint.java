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

import com.example.AchatLocal.Model.BonDeCommande;
import com.example.AchatLocal.Service.BonDeCommandeService;

@RequestMapping("/bonDeCommande")
@CrossOrigin
@RestController
public class BonDeCommandeEndpoint {
	
	@Autowired
	private BonDeCommandeService serv;

	@GetMapping("")
	public List<BonDeCommande> findAllBonDeCommandes() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public BonDeCommande findBonDeCommandeById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveBonDeCommande(@RequestBody BonDeCommande role) {
		serv.saveBonDeCommande(role);
	}
	
	@PutMapping("")
	public void updateBonDeCommande(@RequestBody BonDeCommande role) {
		serv.updateBonDeCommande(role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBonDeCommande(@PathVariable Integer id) {
		serv.deleteBonDeCommande(id);
	}

}
