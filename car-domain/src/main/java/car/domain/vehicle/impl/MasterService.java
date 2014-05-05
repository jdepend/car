package car.domain.vehicle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MasterService {

	@Autowired
	private MasterJpaRepo masterJpaRepo;

	@Cacheable(value = "Master", key = "#masterId + 'obtain'")
	public MasterEntity obtain(String masterId) {
		return masterJpaRepo.findOne(masterId);
	}
	
	@CacheEvict(value = "Master", key = "#entity.getId + 'obtain'")
	public void create(MasterEntity entity){
		entity.save();
	}
	
	@CacheEvict(value = "Master", key = "#entity.getId + 'obtain'")
	public void update(MasterEntity entity){
		entity.save();
	}

}
