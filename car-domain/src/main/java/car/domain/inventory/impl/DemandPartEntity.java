package car.domain.inventory.impl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory_demand_part")
public class DemandPartEntity {
	
	private String id;
	
	private String registerId;
	
	private String vehicleNumber;
	
	private Date createDate;
	
	
	@Id
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getRegisterId() {
		return registerId;
	}



	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}



	public String getVehicleNumber() {
		return vehicleNumber;
	}



	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public void save(){
		
	}

}
