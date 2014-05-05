package car.domain.maintain.register;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface RegisterJpaRepo extends PagingAndSortingRepository<RegisterEntity, String>{

	RegisterEntity findByVehicleNumber(String vehicleNumber);

}
