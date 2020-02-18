package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CollegueVM;
import dev.domain.Collegue;
import dev.repository.CollegueRepo;

@RestController
public class CollegueController {

	private CollegueRepo cRepo;

	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.VehiculeController.class);

	public CollegueController(CollegueRepo cRepo) {
		this.cRepo = cRepo;
	}

	/** Retourne la liste des collegues */
	@RequestMapping(method = RequestMethod.GET, path = "collegues")
	public List<CollegueVM> getCollegue() {
		List<Collegue> listeCollegues = this.cRepo.findAll();
		return listeCollegues.stream().map(col -> new CollegueVM(col)).collect(Collectors.toList());
	}

}
