package com.example.AchatLocal.Endpoint;

import java.sql.Date;
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
import com.example.AchatLocal.Model.HistoriqueArticle;
import com.example.AchatLocal.Service.BonDeSortieService;
import com.example.AchatLocal.Service.HistoriqueArticleService;


@RequestMapping("/bonDeSortie")
@CrossOrigin
@RestController
public class BonDeSortieEndpoint {
	
	@Autowired
	private BonDeSortieService serv;
	
	@Autowired
	private HistoriqueArticleService historiqueServ;

	@GetMapping("")
	public List<BonDeSortie> findAllBonDeSorties() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public BonDeSortie findBonDeSortieById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveBonDeSortie(@RequestBody BonDeSortie b) {
		HistoriqueArticle h = new HistoriqueArticle();
		h.setArticle(b.getDemandeArticle().getArticle());
		h.setDateHistorique(new Date(System.currentTimeMillis()));
		h.setSortie(b.getDemandeArticle().getQuantite());
		h.setMagasinier(b.getMagasinier());
		historiqueServ.saveHistorique(h);
		serv.saveBonDeSortie(b);
	}
	
	@PutMapping("")
	public void updateBonDeSortie(@RequestBody BonDeSortie b) {
		serv.updateBonDeSortie(b);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBonDeSortie(@PathVariable Integer id) {
		serv.deleteBonDeSortie(id);
	}

}
