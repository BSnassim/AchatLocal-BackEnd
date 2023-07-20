package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.DemandeArticle;
import com.example.AchatLocal.Repository.DemandeArticleRepository;

@Service
public class DemandeArticleServiceImpl implements DemandeArticleService {
	
	@Autowired
	private DemandeArticleRepository repo;

	@Override
	public List<DemandeArticle> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public DemandeArticle findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveDemandeArticle(DemandeArticle da) {
		repo.save(da);
	}

	@Override
	public void updateDemandeArticle(DemandeArticle da) {
		repo.save(da);
	}

	@Override
	public void deleteDemandeArticle(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public String natureTraitement(Integer id) {
		repo.find(id);
		if(da.getArticle().getStock() < da.getQuantite()) {
			return da.getArticle().getCategorie().getTypeImportation();
		} else {
			return "Bon de sortie";
		}
	}

}
