package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.ReservationAnnonce;

public interface ReservationAnnonceRepo extends JpaRepository<ReservationAnnonce, Integer> {

	/** Récupérer les réservations sur une annonce */
	public List<ReservationAnnonce> findAllByAnnonce(Annonce annonce);

	/** Récupérer les réservations d'un collègue */
	public List<ReservationAnnonce> findAllByCollegue(Collegue collegue);

}
