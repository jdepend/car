package car.domain.maintain.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import car.domain.inventory.InVentoryFacade;
import car.domain.maintain.RegisterExeception;
import car.domain.maintain.RegisterVO;
import car.domain.vehicle.VehicleFacade;

@Service
public class RegisterService {

	@Autowired
	private VehicleFacade vehicleFacade;

	@Autowired
	private InVentoryFacade inVentoryFacade;

	public void createRegister(RegisterVO registerVO) throws RegisterExeception {

		// ���ɵǼǵ�
		RegisterEntity entity = new RegisterEntity(registerVO);
		entity.save();
		// ���ӿͻ�����
		vehicleFacade.addMasterCredits(entity.getMasterId(), entity
				.getCredits());
		// ������Ҫ�����
		inVentoryFacade.createDemand(entity.getId(), entity.getNumber(), entity
				.calDemandParts());

	}

	public RegisterVO obtain(String registerId) {
		return new RegisterEntity().find(registerId).toRegisterVO();
	}

	public RegisterVO obtainByVehicleNumber(String vehicleNumber) {
		return new RegisterEntity().findByVehicleNumber(vehicleNumber).toRegisterVO();
	}

}
