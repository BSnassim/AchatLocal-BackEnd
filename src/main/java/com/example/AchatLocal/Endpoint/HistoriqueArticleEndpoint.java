package com.example.AchatLocal.Endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AchatLocal.Model.HistoriqueArticle;
import com.example.AchatLocal.Service.HistoriqueArticleService;

@RequestMapping("/historiqueArticle")
@CrossOrigin
@RestController
public class HistoriqueArticleEndpoint {
	
	@Autowired
	private HistoriqueArticleService serv;
	
	@GetMapping("/article/{id}")
	public List<HistoriqueArticle> findAllByArticle(@PathVariable Integer id){
		return serv.findAllByArticle(id);
	}
	
	@GetMapping("")
	public List<HistoriqueArticle> findAll(){
		return serv.findAll();
	}
	
	@PostMapping("")
	public void saveHistorique(@RequestBody HistoriqueArticle h) {
		serv.saveHistorique(h);
	}
	

}
