package car.domain.vehicle.impl;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface VehicleJpaRepo extends PagingAndSortingRepository<VehicleEntity, String>{

}
