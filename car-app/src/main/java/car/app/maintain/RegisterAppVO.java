package car.app.maintain;

import java.util.List;

import car.domain.maintain.RegisterItemVO;
import car.domain.maintain.RegisterVO;

public class RegisterAppVO {

	private String id;

	private String vehicleNumber;

	private List<RegisterItemVO> items;

	private String state;

	public RegisterAppVO() {

	}

	public RegisterAppVO(RegisterVO obtainRegister) {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public List<RegisterItemVO> getItems() {
		return items;
	}

	public void setItems(List<RegisterItemVO> items) {
		this.items = items;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
