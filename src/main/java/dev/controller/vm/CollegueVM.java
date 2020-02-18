package dev.controller.vm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;

/**
 * Structure modèlisant un collègue servant à communiquer avec l'extérieur (WEB
 * API).
 */
public class CollegueVM {
	private Long id;
	private String email;
	private String nom;
	private String prenom;
	private String numeroTel;
	private List<Role> roles = new ArrayList<>();

	public CollegueVM() {
	}

	public CollegueVM(Collegue col) {
		this.id = col.getId();
		this.email = col.getEmail();
		this.nom = col.getNom();
		this.prenom = col.getPrenom();
		this.numeroTel = col.getNumeroTel();
		this.roles = col.getRoles().stream().map(roleCollegue -> roleCollegue.getRole()).collect(Collectors.toList());
	}

	public Collegue toCollegue() {
		Collegue col = new Collegue();
		col.setId(this.id);
		col.setEmail(this.email);
		col.setNom(this.nom);
		col.setPrenom(this.prenom);
		col.setNumeroTel(this.numeroTel);
		List<RoleCollegue> rolesCollegue = this.roles.stream().map(role -> new RoleCollegue(col, role))
				.collect(Collectors.toList());
		col.setRoles(rolesCollegue);
		return col;
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

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
