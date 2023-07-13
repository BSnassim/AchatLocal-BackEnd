package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.DemandeAchat;

public interface DemandeAchatService {
	
	public List<DemandeAchat> findAll();
	public DemandeAchat findById(Integer id);
	public void saveDemandeAchat(DemandeAchat da);
	public void updateDemandeAchat(DemandeAchat da);
	public void deleteDemandeAchat(Integer id);


}
