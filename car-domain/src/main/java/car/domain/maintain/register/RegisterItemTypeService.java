package car.domain.maintain.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RegisterItemTypeService {

	@Autowired
	private RegisterItemTypeJpaRepo registerItemTypeJpaRepo;

	@Cacheable(value = "RegisterItemType", key = "#id + 'obtain'")
	public RegisterItemTypeEntity obtain(String id) {
		return registerItemTypeJpaRepo.findOne(id);
	}

}
