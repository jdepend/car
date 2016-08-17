package car.domain.maintain.cost;

import car.domain.maintain.register.RegisterEntity;

public interface CostService {

	public Cost calculate(RegisterEntity entity);

}
