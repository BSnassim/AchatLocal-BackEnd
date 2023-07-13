package com.example.AchatLocal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	private Integer stock;
	private String caracteristiques;
	private String marque;
	
	@ManyToOne
	@JoinColumn(name="categorie_id", referencedColumnName = "id")
	private Categorie categorie;
}
