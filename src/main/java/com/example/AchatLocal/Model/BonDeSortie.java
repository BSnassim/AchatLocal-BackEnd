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

@Entity
@Table
@Data
public class BonDeSortie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dateSortie;
	
	@ManyToOne
	@JoinColumn(name="demande_article_id", referencedColumnName = "id")
	private DemandeArticle demandeArticle;
	@ManyToOne
	@JoinColumn(name="magasinier_id", referencedColumnName = "id")
	private Utilisateur magasinier;

}
