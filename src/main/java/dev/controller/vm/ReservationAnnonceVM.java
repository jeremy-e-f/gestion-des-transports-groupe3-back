package dev.controller.vm;

import dev.domain.ReservationAnnonce;
import dev.domain.Statut;

public class ReservationAnnonceVM {

	private Integer id;
	private AnnonceVM annonce;
	private CollegueVM collegue;
	private Statut statut;

	/**
	 * Constructeur
	 * 
	 * @param resAnnonce
	 */
	public ReservationAnnonceVM() {

	}

	public ReservationAnnonceVM(ReservationAnnonce resAnnonce) {
		this.id = resAnnonce.getId();
		this.annonce = new AnnonceVM(resAnnonce.getAnnonce());
		this.collegue = new CollegueVM(resAnnonce.getCollegue());
		this.statut = resAnnonce.getStatut();
	}

	public ReservationAnnonce toReservationAnnonce() {
		return new ReservationAnnonce(this.id, this.annonce.toAnnonce(), this.collegue.toCollegue(), this.statut);
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
	public AnnonceVM getAnnonce() {
		return annonce;
	}

	/**
	 * @param annonce
	 *            the annonce to set
	 */
	public void setAnnonce(AnnonceVM annonce) {
		this.annonce = annonce;
	}

	/**
	 * @return the collegue
	 */
	public CollegueVM getCollegue() {
		return collegue;
	}

	/**
	 * @param collegue
	 *            the collegue to set
	 */
	public void setCollegue(CollegueVM collegue) {
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

}
