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

import com.example.AchatLocal.Model.DemandeAchat;
import com.example.AchatLocal.Service.DemandeAchatService;


@RequestMapping("/demandeAchat")
@CrossOrigin
@RestController
public class DemandeAchatEndpoint {
	
	@Autowired
	private DemandeAchatService serv;

	@GetMapping("")
	public List<DemandeAchat> findAllDemandeAchats() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public DemandeAchat findDemandeAchatById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveDemandeAchat(@RequestBody DemandeAchat role) {
		serv.saveDemandeAchat(role);
	}
	
	@PutMapping("")
	public void updateDemandeAchat(@RequestBody DemandeAchat role) {
		serv.updateDemandeAchat(role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDemandeAchat(@PathVariable Integer id) {
		serv.deleteDemandeAchat(id);
	}

}
