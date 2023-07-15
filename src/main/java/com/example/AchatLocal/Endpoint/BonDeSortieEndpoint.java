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

import com.example.AchatLocal.Model.BonDeSortie;
import com.example.AchatLocal.Service.BonDeSortieService;


@RequestMapping("/bonDeSortie")
@CrossOrigin
@RestController
public class BonDeSortieEndpoint {
	
	@Autowired
	private BonDeSortieService serv;

	@GetMapping("")
	public List<BonDeSortie> findAllBonDeSorties() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public BonDeSortie findBonDeSortieById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveBonDeSortie(@RequestBody BonDeSortie role) {
		serv.saveBonDeSortie(role);
	}
	
	@PutMapping("")
	public void updateBonDeSortie(@RequestBody BonDeSortie role) {
		serv.updateBonDeSortie(role);
	}
	
	@DeleteMapping("{id}")
	public void deleteBonDeSortie(@PathVariable Integer id) {
		serv.deleteBonDeSortie(id);
	}

}
