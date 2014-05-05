package car.domain.vehicle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	@Autowired
	private VehicleJpaRepo vehicleJpaRepo;

	@Cacheable(value = "Vehicle", key = "#VehicleId + 'obtain'")
	public VehicleEntity obtain(String vehicleId) {
		return vehicleJpaRepo.findOne(vehicleId);
	}

	@CacheEvict(value = "Vehicle", key = "#entity.getId + 'obtain'")
	public void create(VehicleEntity entity) {
		entity.save();
	}

	@CacheEvict(value = "Vehicle", key = "#entity.getId + 'obtain'")
	public void update(VehicleEntity entity) {
		entity.save();
	}

}
