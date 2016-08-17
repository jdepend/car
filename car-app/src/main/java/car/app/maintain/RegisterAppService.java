package car.app.maintain;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import car.domain.maintain.MaintainFacade;
import car.domain.maintain.RegisterExeception;
import car.domain.maintain.RegisterVO;

@Service
public class RegisterAppService {

	@Autowired
	private MaintainFacade maintainFacade;

	@Transactional(readOnly = false)
	public void create(RegisterAppVO register) throws RegisterExeception {
		// 创建维修登记单
		RegisterVO registerVO = new RegisterVO();
		BeanUtils.copyProperties(register, registerVO);
		maintainFacade.createRegister(registerVO);

	}

	@Transactional(readOnly = true)
	public RegisterAppVO obtain(String registerId) {
		return new RegisterAppVO(maintainFacade.obtainRegister(registerId));
	}

	@Transactional(readOnly = true)
	public RegisterAppVO obtainByVehicleNumber(String vehicleNumber) {
		return new RegisterAppVO(maintainFacade
				.obtainByVehicleNumber(vehicleNumber));
	}

}
