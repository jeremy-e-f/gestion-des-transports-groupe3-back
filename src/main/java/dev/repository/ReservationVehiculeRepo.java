package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationVehicule;

public interface ReservationVehiculeRepo extends JpaRepository<ReservationVehicule, Integer> {

}
