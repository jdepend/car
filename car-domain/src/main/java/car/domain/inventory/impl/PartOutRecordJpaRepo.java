package car.domain.inventory.impl;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PartOutRecordJpaRepo extends
		PagingAndSortingRepository<PartOutRecordEntity, String> {
}
