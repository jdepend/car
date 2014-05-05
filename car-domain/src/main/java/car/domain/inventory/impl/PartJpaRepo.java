package car.domain.inventory.impl;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PartJpaRepo extends
		PagingAndSortingRepository<PartEntity, String> {

}
