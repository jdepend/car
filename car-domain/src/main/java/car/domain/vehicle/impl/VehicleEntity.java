package car.domain.vehicle.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import car.domain.vehicle.VehicleVO;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {

	private String number;

	private String type;

	private String masterId;

	private int mileage;

	@Autowired
	private VehicleJpaRepo vehicleJpaRepo;

	public VehicleEntity() {

	}

	public VehicleEntity(VehicleVO vehicle) {
		BeanUtils.copyProperties(vehicle, this);
	}

	@Id
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "master_id")
	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public void save() {
		this.vehicleJpaRepo.save(this);
	}

	public VehicleVO toVehicleVO() {
		VehicleVO vehicle = new VehicleVO();

		BeanUtils.copyProperties(this, vehicle);

		return vehicle;
	}

}
