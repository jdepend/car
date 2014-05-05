package car.domain.inventory.impl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import car.infrastructure.util.DateUtil;

@Entity
@Table(name = "inventory_part_instance")
public class PartInstanceEntity {

	private String code;
	private String number;
	private String state;
	private String vehicleNumber;
	private Date outDate;

	@Autowired
	private PartInstanceJpaRepo partInstanceJpaRepo;

	public final static String OUT = "OUT";

	@Id
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setOUTState(String vehicleNumber) {
		this.state = OUT;
		this.vehicleNumber = vehicleNumber;
		this.outDate = DateUtil.getSysDate();
	}

	public void save() {
		partInstanceJpaRepo.save(this);

	}

}
