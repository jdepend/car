package car.domain.inventory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import car.domain.inventory.PartSpecVO;

@Service
public class PartSpecService {

	@Autowired
	private PartJpaRepo partJpaRepo;

	@Cacheable(value = "PartSpec", key = "#number + 'obtain'")
	public PartSpecVO obtain(String number) {
		return partJpaRepo.findOne(number).toPartSpecVO();
	}

}
