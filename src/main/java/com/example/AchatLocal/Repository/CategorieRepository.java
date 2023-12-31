package com.example.AchatLocal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer>{
	
	List<Categorie> findAllByTypeImportation(String type);

}
