package car.domain.maintain.cost;

import org.springframework.stereotype.Service;

import car.domain.maintain.register.RegisterEntity;

@Service
public interface CostService {

	public Cost calculate(RegisterEntity entity);

}
