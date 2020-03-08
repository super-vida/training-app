package cz.prague.vida.training;

import static cz.prague.vida.training.Logger.logger;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import cz.prague.vida.training.entity.TrainingZone;
import cz.prague.vida.training.entity.User;

@ApplicationScoped
public class TrainingApp {

	@Inject
	private TrainingParser trainngParser;

	public void run() throws Exception {
		User user = loadUser();
		logger.info("\n----------------------------------------------\nStaring Training application");
		trainngParser.parse(user, "ride.gpx");
		logger.info("Closing Training application\n----------------------------------------------\n");

	}

	private User loadUser() {
		User user = new User();
		user.setFirstName("Jan");
		user.setLastName("Vacek");
		user.setUserName("vida");
		user.setEmail("vacek.honza@gamil.com");
		List<TrainingZone> zones = new ArrayList<TrainingZone>();
		TrainingZone zone = new TrainingZone();
		zone.setName("Recovery");
		zone.setId(1L);
		zone.setFrom(104);
		zone.setTo(129);
		zones.add(zone);
		zone = new TrainingZone();
		zone.setId(2L);
		zone.setName("Aerobic");
		zone.setFrom(130);
		zone.setTo(143);
		zones.add(zone);
		zone = new TrainingZone();
		zone.setId(3L);
		zone.setName("Tempo");
		zone.setFrom(144);
		zone.setTo(148);
		zones.add(zone);
		zone = new TrainingZone();
		zone.setName("SubThreshold");
		zone.setId(4L);
		zone.setFrom(149);
		zone.setTo(159);
		zones.add(zone);
		zone = new TrainingZone();
		zone.setId(5L);
		zone.setName("SuperThreshold");
		zone.setFrom(160);
		zone.setTo(163);
		zones.add(zone);
		zone = new TrainingZone();
		zone.setId(6L);
		zone.setName("Aerobic Capacity");
		zone.setFrom(164);
		zone.setTo(169);
		zones.add(zone);
		zone = new TrainingZone();
		zone.setId(7L);
		zone.setName("Anaerobic Capacity");
		zone.setFrom(170);
		zone.setTo(255);
		zones.add(zone);
		user.setTrainingZones(zones);
		return user;
	}
}