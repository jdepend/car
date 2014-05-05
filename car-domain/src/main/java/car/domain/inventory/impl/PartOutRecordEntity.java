package car.domain.inventory.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "part_out_record")
public class PartOutRecordEntity {

	private String id;

	private String registerId;

	private String vehicleNumber;

	private String message;

	private Map<String, Integer> outParts;

	private Collection<String> codes;

	private String userId;

	private Date createDate;

	private PartOutRecordJpaRepo partOutRecordJpaRepo;

	public PartOutRecordEntity() {
		super();
	}

	public PartOutRecordEntity(String registerId, String vehicleNumber,
			Map<String, Integer> outParts, Collection<String> codes) {
		super();
		this.registerId = registerId;
		this.vehicleNumber = vehicleNumber;
		this.outParts = outParts;
		this.codes = codes;

		this.calMessage();
	}

	private void calMessage() {
		this.message = this.outParts.toString() + this.codes.toString();
	}

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

	@Column(name = "vehicle_number")
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void save() {
		this.partOutRecordJpaRepo.save(this);
	}

}
