package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.DemandeAchat;

@Repository
public interface DemandeAchatRepository extends JpaRepository<DemandeAchat, Integer>{

}
