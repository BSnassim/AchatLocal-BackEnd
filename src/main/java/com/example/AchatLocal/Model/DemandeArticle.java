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
public class DemandeArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dateDa;
	private Integer quantite;
	private String besoin;
	private String extraDetails;
	
	@ManyToOne
	@JoinColumn(name="article_id", referencedColumnName = "id")
	private Article article;
	@ManyToOne
	@JoinColumn(name="demandeur_id", referencedColumnName = "id")
	private Utilisateur demandeur;

}
