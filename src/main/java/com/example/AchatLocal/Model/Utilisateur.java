package com.example.AchatLocal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Table
@Entity
@Data
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String password;
	private String prenom;
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName = "id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="departement_id", referencedColumnName = "id")
	private Departement departement;

}
