package car.domain.maintain.register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;

import car.domain.maintain.RegisterItemVO;
import car.domain.maintain.RegisterVO;
import car.domain.maintain.cost.Cost;
import car.domain.maintain.cost.CostService;
import car.domain.maintain.credits.CreditsService;
import car.domain.vehicle.MasterVO;
import car.domain.vehicle.VehicleFacade;
import car.domain.vehicle.VehicleVO;
import car.infrastructure.util.ApplicationContextUtil;

@Entity
@Table(name = "maintain_register")
public class RegisterEntity {

	private String id;

	private Cost cost = new Cost();

	private int credits;

	private VehicleVO vehicle;

	private MasterVO master;

	private List<RegisterItemEntity> items = new ArrayList<RegisterItemEntity>();

	private String state;

	public RegisterEntity() {

	}

	public RegisterEntity(RegisterVO registerVO) {
		// 计算费用和积分
		this.cost = this.getCostService().calculate(this);
		this.credits = this.getCreditsService().calCredits(this);

		// 创建items
		RegisterItemEntity itemEntity = null;
		for (RegisterItemVO item : registerVO.getItems()) {
			itemEntity = new RegisterItemEntity();
			BeanUtils.copyProperties(item, itemEntity);
			this.addItem(itemEntity);
		}
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return vehicle.getNumber();
	}

	public void setNumber(String number) {
		this.vehicle = this.getVehicleFacade().obtainVehicle(number);
	}

	@Column(name = "master_id")
	public String getMasterId() {
		return master.getId();
	}

	public void setMasterId(String masterId) {
		this.master = this.getVehicleFacade().obtainMaster(masterId);
	}

	public List<RegisterItemEntity> obtainItems() {
		return this.items;
	}

	public void addItem(RegisterItemEntity item) {
		this.items.add(item);
		item.setRegister(this);
	}

	@Column(name = "manual_price")
	public Float getManualPrice() {
		return this.cost.getManualPrice();
	}

	public void setManualPrice(Float manualPrice) {
		this.cost.setManualPrice(manualPrice);
	}

	@Column(name = "part_price")
	public Float getPartPrice() {
		return this.cost.getPartPrice();
	}

	public void setPartPrice(Float partPrice) {
		this.cost.setPartPrice(partPrice);
	}

	public Float obtainPrice() {
		return this.cost.getPrice();
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void save() {
		this.getRegisterJpaRepo().save(this);

		for (RegisterItemEntity item : this.items) {
			item.save();
		}
	}

	public RegisterEntity find(String id) {
		RegisterEntity entity = this.getRegisterJpaRepo().findOne(id);

		for (RegisterItemEntity item : this.getRegisterItemJpaRepo()
				.findByRegisterId(id)) {
			entity.addItem(item);
		}

		return entity;
	}

	public RegisterEntity findByVehicleNumber(String vehicleNumber) {
		RegisterEntity entity = this.getRegisterJpaRepo().findByVehicleNumber(
				vehicleNumber);

		for (RegisterItemEntity item : this.getRegisterItemJpaRepo()
				.findByRegisterId(id)) {
			entity.addItem(item);
		}

		return entity;
	}

	public Map<String, Integer> calDemandParts() {

		Map<String, Integer> demandParts = new HashMap<String, Integer>();

		for (RegisterItemEntity item : this.items) {
			if (item.needPart()) {
				demandParts.put(item.getPartNumber(), item.getPartCount());
			}
		}
		return demandParts;
	}

	public RegisterVO toRegisterVO() {

		RegisterVO registerVO = new RegisterVO();
		BeanUtils.copyProperties(this, registerVO);
		return registerVO;
	}

	@Transient
	private RegisterJpaRepo getRegisterJpaRepo() {
		return (RegisterJpaRepo) ApplicationContextUtil.getApplicationContext()
				.getBean("registerJpaRepo");
	}

	@Transient
	private RegisterItemJpaRepo getRegisterItemJpaRepo() {
		return (RegisterItemJpaRepo) ApplicationContextUtil
				.getApplicationContext().getBean("registerItemJpaRepo");
	}

	@Transient
	private CostService getCostService() {
		return (CostService) ApplicationContextUtil.getApplicationContext()
				.getBean("costService");
	}

	@Transient
	private CreditsService getCreditsService() {
		return (CreditsService) ApplicationContextUtil.getApplicationContext()
				.getBean("creditsService");
	}

	@Transient
	private VehicleFacade getVehicleFacade() {
		return (VehicleFacade) ApplicationContextUtil.getApplicationContext()
				.getBean("vehicleFacade");
	}

}