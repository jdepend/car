package car.domain.maintain.register;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RegisterItemJpaRepo extends
		PagingAndSortingRepository<RegisterItemEntity, String> {

	List<RegisterItemEntity> findByRegisterId(String registerId);

}
