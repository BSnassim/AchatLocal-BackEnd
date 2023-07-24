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

import com.example.AchatLocal.Model.Categorie;
import com.example.AchatLocal.Service.CategorieService;

@RequestMapping("/categorie")
@CrossOrigin
@RestController
public class CategorieEndpoint {
	
	@Autowired
	private CategorieService serv;

	@GetMapping("")
	public List<Categorie> findAllCategories() {
		return serv.findAll();
	}
	
	@GetMapping("/ByType/{type}")
	public List<Categorie> findAllCategoriesByType(@PathVariable String type) {
		return serv.findAllByType(type);
	}

	@GetMapping("/{id}")
	public Categorie findCategorieById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveCategorie(@RequestBody Categorie role) {
		serv.saveCategorie(role);
	}
	
	@PutMapping("")
	public void updateCategorie(@RequestBody Categorie role) {
		serv.updateCategorie(role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategorie(@PathVariable Integer id) {
		serv.deleteCategorie(id);
	}

}
