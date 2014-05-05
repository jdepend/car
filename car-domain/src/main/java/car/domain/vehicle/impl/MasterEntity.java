package car.domain.vehicle.impl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import car.domain.vehicle.MasterVO;

@Entity
@Table(name = "master")
public class MasterEntity {

	private String id;

	private String name;

	private String phone;

	private String credits;

	@Autowired
	private MasterJpaRepo masterJpaRepo;

	public MasterEntity() {

	}

	public MasterEntity(MasterVO master) {

	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public void addCredits(int credits2) {
		this.credits += credits2;

	}

	public void save() {
		masterJpaRepo.save(this);
	}

	public MasterVO toMasterVO() {
		// TODO Auto-generated method stub
		return null;
	}
}
