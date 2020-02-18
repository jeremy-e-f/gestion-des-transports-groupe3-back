package dev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Vehicule;
import dev.repository.VehiculeRepo;

@RestController
public class VehiculeController {

	private VehiculeRepo vRepo;

	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.VehiculeController.class);

	public VehiculeController(VehiculeRepo vRepo) {
		this.vRepo = vRepo;
	}

	/** Retourne la liste ds véhicules */
	@RequestMapping(method = RequestMethod.GET, path = "vehicules")
	public List<Vehicule> getVehicule() {
		List<Vehicule> listeVehicules = this.vRepo.findAll();
		return listeVehicules;
	}

}
