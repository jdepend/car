package car.domain.vehicle.impl;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface MasterJpaRepo extends PagingAndSortingRepository<MasterEntity, String>{

}
