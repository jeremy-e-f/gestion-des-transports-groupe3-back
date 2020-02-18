package dev;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Annonce;
import dev.domain.CategorieVehicule;
import dev.domain.Chauffeur;
import dev.domain.Collegue;
import dev.domain.ReservationAnnonce;
import dev.domain.ReservationVehicule;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Statut;
import dev.domain.StatutVehicule;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.repository.AnnonceRepo;
import dev.repository.ChauffeurRepo;
import dev.repository.CollegueRepo;
import dev.repository.ReservationVehiculeRepo;
import dev.repository.VehiculeRepo;
import dev.repository.VersionRepo;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollegueRepo collegueRepo;
	private ChauffeurRepo chauffeurRepo;
	private AnnonceRepo annonceRepo;
	private VehiculeRepo vehiculeRepo;
	private ReservationVehiculeRepo reserVehiRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, ChauffeurRepo chauffeurRepo,
			VehiculeRepo vehiculeRepo, AnnonceRepo annonceRepo, ReservationVehiculeRepo reserVehiRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.chauffeurRepo = chauffeurRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.annonceRepo = annonceRepo;
		this.reserVehiRepo = reserVehiRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

		Collegue col1 = new Collegue();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollegue(col1, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col1, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col1);

		Collegue col2 = new Collegue();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollegue(col2, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col2);

		Chauffeur col3 = new Chauffeur(3L, "JEAN", "Dimitri", "d.jean@gmail.com", "Soleil123", "0748859586", null,
				"DE54869233", "154884818484");
		col3.setRoles(Arrays.asList(new RoleCollegue(col3, Role.ROLE_UTILISATEUR)));
		this.chauffeurRepo.save(col3);

		Collegue col4 = new Collegue(4L, "KAFE", "Josh", "j.kafe@orange.fr", "Soleil123", "0798521258", null);
		col4.setRoles(Arrays.asList(new RoleCollegue(col4, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col4);

		Collegue col5 = new Collegue(5L, "LAROCHE", "Mattis", "m.laroche@gmail.com", "Soleil123", "0658124125", null);
		col5.setRoles(Arrays.asList(new RoleCollegue(col5, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col5);

		/** Exemples de véhicules */
		Vehicule v1 = new Vehicule(1, "Citroën", "Xantia", CategorieVehicule.BERLINES_M,
				"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Citroen_Xantia_front_20080228.jpg/280px-Citroen_Xantia_front_20080228.jpg",
				StatutVehicule.EN_SERVICE, 5);
		Vehicule v2 = new Vehicule(2, "BMW", "M3 Coupé", CategorieVehicule.BERLINES_L,
				"https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/BMW_M3_E46_Coupe.JPG/280px-BMW_M3_E46_Coupe.JPG",
				StatutVehicule.EN_REPARATION, 5);
		Vehicule v3 = new Vehicule(3, "Renault", "Twingo", CategorieVehicule.MICROURBAINES,
				"https://upload.wikimedia.org/wikipedia/commons/f/fb/Renault_Twingo.jpg", StatutVehicule.EN_SERVICE, 4);
		Vehicule v4 = new Vehicule(4, "Renault", "Grand Scenic", CategorieVehicule.COMPACTES,
				"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Renault_Scenic_front_20080213.jpg/1280px-Renault_Scenic_front_20080213.jpg",
				StatutVehicule.EN_SERVICE, 7);
		Vehicule v5 = new Vehicule(5, "Renault", "Clio 3", CategorieVehicule.MINICITADINES,
				"https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Renault_Clio_front_20071102.jpg/280px-Renault_Clio_front_20071102.jpg",
				StatutVehicule.EN_SERVICE, 5);
		for (Vehicule v : Arrays.asList(v1, v2, v3, v4, v5)) {
			this.vehiculeRepo.save(v);
		}

		/** Exemple de réservation de véhicule de fonction */
		ReservationVehicule rv1 = new ReservationVehicule(1,
				LocalDateTime.parse("17/12/2019 05:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")),
				LocalDateTime.parse("17/12/2019 21:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")), false, col5,
				v2, null);
		ReservationVehicule rv2 = new ReservationVehicule(2,
				LocalDateTime.parse("01/11/2019 05:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")),
				LocalDateTime.parse("02/11/2019 21:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")), false, col5,
				v3, null);
		ReservationVehicule rv3 = new ReservationVehicule(3,
				LocalDateTime.parse("10/05/2019 07:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")),
				LocalDateTime.parse("10/05/2019 14:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")), true, col4,
				v5, col3);
		for (ReservationVehicule rv : Arrays.asList(rv1, rv2, rv3)) {
			this.reserVehiRepo.save(rv);
		}

		/** Exemple d'annonces de covoiturage */
		Annonce a1 = new Annonce(1, "43 bis Avenue d'Albi Blaye-les-mines 81400",
				"DIGINAMIC 297 rue Maurice Béjart, 34080 Montpellier", "325 ECB 19", "Citroën", "Xantia", 5,
				LocalDateTime.parse("10/11/2019 05:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")),
				Statut.ACTIF, col4);
		a1.setReservations(Arrays.asList(new ReservationAnnonce(a1, col2, Statut.ACTIF),
				new ReservationAnnonce(a1, col5, Statut.ACTIF)));
		Annonce a2 = new Annonce(2, "43 bis Avenue d'Albi Blaye-les-mines 81400",
				"DIGINAMIC 297 rue Maurice Béjart, 34080 Montpellier", "325 ECB 19", "Citroën", "Xantia", 5,
				LocalDateTime.parse("17/12/2019 05:00", DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm")),
				Statut.ACTIF, col4);
		a2.setReservations(Arrays.asList(new ReservationAnnonce(a2, col2, Statut.ANNULE),
				new ReservationAnnonce(a2, col5, Statut.ACTIF)));
		Annonce a3 = new Annonce(3, "43 bis Avenue d'Albi Blaye-les-mines 81400",
				"DIGINAMIC 297 rue Maurice Béjart, 34080 Montpellier", "325 ECB 19", "Citroën", "Xantia", 5,
				LocalDateTime.now(), Statut.ACTIF, col4);
		for (Annonce a : Arrays.asList(a1, a2, a3)) {
			this.annonceRepo.save(a);
		}

	}

}
