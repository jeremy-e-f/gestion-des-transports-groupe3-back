package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationAnnonce;

public interface ReservationAnnonceRepo extends JpaRepository<ReservationAnnonce, Integer> {

}
