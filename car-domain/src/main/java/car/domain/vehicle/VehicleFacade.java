package car.domain.vehicle;


public interface VehicleFacade {

	public VehicleVO obtainVehicle(String number);

	public void createVehicle(VehicleVO vehicle);

	public MasterVO obtainMaster(String id);

	public void createMaster(MasterVO master);

	public void addMasterCredits(String masterId, int credits);

	public void updateVehicleMileage(String vehicleId, int mileage);

}
