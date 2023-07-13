package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.BonDeCommande;

@Repository
public interface BonDeCommandeRepository extends JpaRepository<BonDeCommande, Integer>{

}
