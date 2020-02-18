package dev.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Représente le concept d'une réservation en covoiturage
 * 
 * @author Diginamic
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "annonce_id", "collegue_id" }))
public class ReservationAnnonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** Identifiant d'une réservation de covoiturage */

	@ManyToOne
	@JoinColumn(name = "annonce_id")
	private Annonce annonce;
	/** Annonce de la réservation */

	@ManyToOne
	@JoinColumn(name = "collegue_id")
	private Collegue collegue;
	/** Passager du covoiturage */

	@Enumerated(EnumType.STRING)
	private Statut statut;

	/** Statut de la réservation: ANNULE, ACTIF */

	/**
	 * Constructeurs
	 */
	public ReservationAnnonce() {
	}

	public ReservationAnnonce(Annonce annonce, Collegue collegue, Statut statut) {
		this.annonce = annonce;
		this.collegue = collegue;
		this.statut = statut;
	}

	public ReservationAnnonce(Integer id, Annonce annonce, Collegue collegue, Statut statut) {
		this(annonce, collegue, statut);
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the annonce
	 */
	public Annonce getAnnonce() {
		return annonce;
	}

	/**
	 * @param annonce
	 *            the annonce to set
	 */
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	/**
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * @param collegue
	 *            the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	/**
	 * @return the statut
	 */
	public Statut getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Passager [annonce=" + annonce + ", collegue=" + collegue + ", statut=" + statut + "]";
	}

}
