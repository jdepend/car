package car.domain.maintain.register;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RegisterItemTypeJpaRepo extends
		PagingAndSortingRepository<RegisterItemTypeEntity, String> {

}
