package car.domain.maintain;

import java.util.List;

public class RegisterVO {

	private String id;

	private String vehicleNumber;

	private List<RegisterItemVO> items;

	private String state;

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
