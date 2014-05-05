package car.domain.inventory;

import java.util.Collection;
import java.util.Map;

import car.infrastructure.exception.CarException;

public interface InVentoryFacade {

	public void createDemand(String registerId, String vehicleNumber,
			Map<String, Integer> demandParts);

	public PartSpecVO obtainPartSpec(String number);

	public void out(String registerId, String vehicleNumber,
			Map<String, Integer> demandParts, Collection<String> codes)
			throws CarException;

}
