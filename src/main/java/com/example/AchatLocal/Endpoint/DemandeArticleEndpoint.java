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

import com.example.AchatLocal.Model.DemandeArticle;
import com.example.AchatLocal.Service.DemandeArticleService;

@RequestMapping("/demandeArticle")
@CrossOrigin
@RestController
public class DemandeArticleEndpoint {
	
	@Autowired
	private DemandeArticleService serv;

	@GetMapping("")
	public List<DemandeArticle> findAllDemandeArticles() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public DemandeArticle findDemandeArticleById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveDemandeArticle(@RequestBody DemandeArticle role) {
		serv.saveDemandeArticle(role);
	}
	
	@PutMapping("")
	public void updateDemandeArticle(@RequestBody DemandeArticle role) {
		serv.updateDemandeArticle(role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDemandeArticle(@PathVariable Integer id) {
		serv.deleteDemandeArticle(id);
	}

}
