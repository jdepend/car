package car.domain.inventory.impl;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import car.domain.inventory.InVentoryFacade;
import car.domain.inventory.PartSpecVO;
import car.infrastructure.exception.CarException;

@Service
public class InVentoryFacadeImpl implements InVentoryFacade {

	@Autowired
	private OutLibraryService outLibraryService;

	@Autowired
	private InLibraryService inLibraryService;

	@Autowired
	private PartSpecService partSpecService;

	@Override
	public void createDemand(String registerId, String vehicleNumber,
			Map<String, Integer> demandParts) {
		outLibraryService.createDemand(registerId, vehicleNumber, demandParts);

	}

	@Override
	public PartSpecVO obtainPartSpec(String number) {
		return partSpecService.obtain(number);
	}

	@Override
	public void out(String registerId, String vehicleNumber,
			Map<String, Integer> demandParts, Collection<String> codes)
			throws CarException {
		outLibraryService.out(registerId, vehicleNumber, demandParts, codes);
	}

}
