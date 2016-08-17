package car.domain.maintain;

import org.springframework.stereotype.Service;

@Service
public interface MaintainFacade {

	public void createRegister(RegisterVO registerEntity) throws RegisterExeception;

	public RegisterVO obtainRegister(String registerId);

	public RegisterVO obtainByVehicleNumber(String vehicleNumber);

}
