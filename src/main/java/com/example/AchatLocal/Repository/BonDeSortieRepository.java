package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.BonDeSortie;

@Repository
public interface BonDeSortieRepository extends JpaRepository<BonDeSortie, Integer> {

}
