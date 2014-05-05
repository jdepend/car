package car.domain.maintain.register;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maintian_item_type")
public class RegisterItemTypeEntity {

	private String type;

	private Float manualPrice;

	private int needTime;// 单位小时

	@Id
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getManualPrice() {
		return manualPrice;
	}

	public void setManualPrice(Float manualPrice) {
		this.manualPrice = manualPrice;
	}

	public int getNeedTime() {
		return needTime;
	}

	public void setNeedTime(int needTime) {
		this.needTime = needTime;
	}

}
