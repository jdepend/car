package car.domain.vehicle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import car.domain.vehicle.MasterVO;
import car.domain.vehicle.VehicleFacade;
import car.domain.vehicle.VehicleVO;

@Service("vehicleFacade")
public class VehicleFacadeImpl implements VehicleFacade {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private MasterService masterService;

	@Override
	public void createVehicle(VehicleVO vehicle) {
		VehicleEntity entity = new VehicleEntity(vehicle);
		vehicleService.create(entity);
	}

	@Override
	public VehicleVO obtainVehicle(String number) {
		VehicleEntity entity = vehicleService.obtain(number);
		return entity.toVehicleVO();
	}

	@Override
	public void addMasterCredits(String masterId, int credits) {
		MasterEntity entity = masterService.obtain(masterId);
		entity.addCredits(credits);
		entity.save();
	}

	@Override
	public void createMaster(MasterVO master) {
		masterService.create(new MasterEntity(master));
	}

	@Override
	public MasterVO obtainMaster(String id) {
		return masterService.obtain(id).toMasterVO();
	}

	@Override
	public void updateVehicleMileage(String vehicleId, int mileage) {
		// TODO Auto-generated method stub
		
	}

}
