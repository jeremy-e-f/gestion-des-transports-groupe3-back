package dev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Annonce;
import dev.repository.AnnonceRepo;

@RestController
public class AnnonceController {

	private AnnonceRepo aRepo;

	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.VehiculeController.class);

	public AnnonceController(AnnonceRepo aRepo) {
		this.aRepo = aRepo;
	}

	/** Retourne la liste des annonces */
	@RequestMapping(method = RequestMethod.GET, path = "annonces")
	public List<Annonce> getAll() {
		List<Annonce> listeAnnonces = this.aRepo.findAll();
		return listeAnnonces;
	}

	/**
	 * Permet de créer une annonce
	 * 
	 * @param annonceReçue
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "annonces")
	public ResponseEntity<String> creer(@RequestBody Annonce annonceRecue) {
		this.aRepo.save(annonceRecue);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body("L'annonce " + annonceRecue + " a été créée avec succès!");
	}

}
