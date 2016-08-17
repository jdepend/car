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

		// 生成登记单
		RegisterEntity entity = new RegisterEntity(registerVO);
		entity.save();
		// 增加客户积分
		vehicleFacade.addMasterCredits(entity.getMasterId(), entity
				.getCredits());
		// 创建需要的配件
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
