package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.DemandeAchat;
import com.example.AchatLocal.Repository.DemandeAchatRepository;

@Service
public class DemandeAchatServiceImpl implements DemandeAchatService {
	
	@Autowired
	private DemandeAchatRepository repo;

	@Override
	public List<DemandeAchat> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public DemandeAchat findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveDemandeAchat(DemandeAchat da) {
		repo.save(da);
	}

	@Override
	public void updateDemandeAchat(DemandeAchat da) {
		repo.save(da);
	}

	@Override
	public void deleteDemandeAchat(Integer id) {
		repo.deleteById(id);
	}

}
