package car.domain.maintain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import car.domain.maintain.MaintainFacade;
import car.domain.maintain.RegisterExeception;
import car.domain.maintain.RegisterVO;
import car.domain.maintain.register.RegisterService;

@Service
public class MaintainFacadeImpl implements MaintainFacade {

	@Autowired
	private RegisterService registerService;

	@Override
	public void createRegister(RegisterVO registerVO) throws RegisterExeception {
		registerService.createRegister(registerVO);
	}

	@Override
	public RegisterVO obtainRegister(String registerId) {
		return registerService.obtain(registerId);
	}

	@Override
	public RegisterVO obtainByVehicleNumber(String vehicleNumber) {
		return registerService.obtainByVehicleNumber(vehicleNumber);
	}

}
