package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.ReservationVehicule;
import dev.domain.Vehicule;

public class ReservationVehiculeVM {

	private Integer id;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private boolean avecChauffeur;
	private CollegueVM collegue;
	private Vehicule vehicule;
	private ChauffeurVM chauffeur;

	public ReservationVehiculeVM() {
	}

	public ReservationVehiculeVM(ReservationVehicule resVehicule) {
		this.id = resVehicule.getId();
		this.dateDebut = resVehicule.getDateDebut();
		this.dateFin = resVehicule.getDateFin();
		this.avecChauffeur = resVehicule.isAvecChauffeur();
		this.collegue = new CollegueVM(resVehicule.getCollegue());
		this.vehicule = resVehicule.getVehicule();
		if (resVehicule.getChauffeur() != null)
			this.chauffeur = new ChauffeurVM(resVehicule.getChauffeur());
	}

	public ReservationVehicule toReservationVehicule() {
		return new ReservationVehicule(this.id, this.dateDebut, this.dateFin, this.avecChauffeur,
				this.collegue.toCollegue(), this.vehicule, this.chauffeur.toChauffeur());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isAvecChauffeur() {
		return avecChauffeur;
	}

	public void setAvecChauffeur(boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
	}

	public CollegueVM getCollegue() {
		return collegue;
	}

	public void setCollegue(CollegueVM collegue) {
		this.collegue = collegue;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public ChauffeurVM getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(ChauffeurVM chauffeur) {
		this.chauffeur = chauffeur;
	}

}
