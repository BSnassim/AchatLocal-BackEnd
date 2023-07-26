package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.HistoriqueArticle;
import com.example.AchatLocal.Repository.HistoriqueArticleRepository;

@Service
public class HistoriqueArticleServiceImpl implements HistoriqueArticleService {

	@Autowired
	private HistoriqueArticleRepository repo;
	
	@Override
	public List<HistoriqueArticle> findAll() {
		return (repo.findAll() != null) ? repo.findAll() : null;
	}

	@Override
	public List<HistoriqueArticle> findAllByArticle(Integer id) {
		return (repo.findAllByArticleId(id) != null) ? repo.findAllByArticleId(id) : null;
	}

	@Override
	public HistoriqueArticle findById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void saveHistorique(HistoriqueArticle h) {
		repo.save(h);
	}

	@Override
	public void updateHistorique(HistoriqueArticle h) {
		repo.save(h);
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

}
