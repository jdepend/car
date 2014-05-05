package car.domain.inventory.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PartInstanceJpaRepo extends
		PagingAndSortingRepository<PartInstanceEntity, String> {

	public List<PartInstanceEntity> findByCodeIn(Collection<String> codes);

}
