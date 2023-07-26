package com.example.AchatLocal.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
	@JoinColumn(name = "categorie_id", referencedColumnName = "id")
	private Categorie categorie;
	
	@OneToMany(mappedBy = "article")
	@Transient
	private List<HistoriqueArticle> historique;

	public void reduceStock(Integer quantite) {
		if (quantite <= this.stock) {
			this.stock -= quantite;
		} else {
			System.out.println("Quantite souhaité superieure au stock !");
		}
	}
}
