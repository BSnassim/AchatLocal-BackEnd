package com.example.AchatLocal.Model;

import java.sql.Date;

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
public class DemandeAchat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dateAchat;
	private Integer quantite;
	private String extraArticle;

	@ManyToOne
	@JoinColumn(name="extraCategorie", referencedColumnName = "id")
	private Categorie extraCategorie;
	
	@ManyToOne
	@JoinColumn(name="article_id", referencedColumnName = "id")
	private Article article;

	@ManyToOne
	@JoinColumn(name="magasinier_id", referencedColumnName = "id")
	private Utilisateur magasinier;

}
