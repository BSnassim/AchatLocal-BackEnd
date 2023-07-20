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

import com.example.AchatLocal.Model.Departement;
import com.example.AchatLocal.Service.DepartementService;

@RequestMapping("/departements")
@CrossOrigin
@RestController
public class DepartementEndpoint {
	
	@Autowired
	private DepartementService serv;

	@GetMapping("")
	public List<Departement> findAllDepartements() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public Departement findDepartementById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveDepartement(@RequestBody Departement departement) {
		serv.saveDepartement(departement);
	}
	
	@PutMapping("")
	public void updateDepartement(@RequestBody Departement departement) {
		serv.updateDepartement(departement);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartement(@PathVariable Integer id) {
		serv.deleteDepartement(id);
	}


}
