package dev.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * Représente le concept de collègue
 * 
 * @author Diginamc
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** Identifiant d'un collegue */

	private String nom;
	/** Nom d'un collègue */

	private String prenom;
	/** Prénom d'une collègue */

	private String email;
	/** Adresse email d'un collègue */

	private String motDePasse;
	/** Mot de passe d'un collègue */

	private String numeroTel;
	/** Numéro de téléphone d'un collègue */

	@OneToMany(mappedBy = "collegue", cascade = CascadeType.PERSIST)
	private List<RoleCollegue> roles;

	/**
	 * Constructeurs
	 */
	public Collegue() {
	}

	public Collegue(Long id, String nom, String prenom, String email, String motDePasse, String numeroTel,
			List<RoleCollegue> roles) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.numeroTel = numeroTel;
		this.roles = roles;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<RoleCollegue> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleCollegue> roles) {
		this.roles = roles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
