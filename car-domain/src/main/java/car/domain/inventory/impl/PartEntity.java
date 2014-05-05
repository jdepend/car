package car.domain.inventory.impl;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import car.domain.inventory.PartSpecVO;
import car.infrastructure.exception.CarException;

@Entity
@Table(name = "part")
public class PartEntity {

	private String number;

	private String name;

	private Float salePrice;

	private boolean manageBarCode;

	private int inventoryCount;

	private int subscriptionedCount;

	private int registedCount;

	@Autowired
	private PartJpaRepo partJpaRepo;

	@Autowired
	private PartInstanceJpaRepo partInstanceJpaRepo;

	@Id
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sale_price")
	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name = "manage_bar_code")
	public boolean isManageBarCode() {
		return manageBarCode;
	}

	public void setManageBarCode(boolean manageBarCode) {
		this.manageBarCode = manageBarCode;
	}

	@Column(name = "inventory_count")
	public int getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	@Column(name = "subscriptioned_count")
	public int getSubscriptionedCount() {
		return subscriptionedCount;
	}

	public void setSubscriptionedCount(int subscriptionedCount) {
		this.subscriptionedCount = subscriptionedCount;
	}

	@Column(name = "registed_count")
	public int getRegistedCount() {
		return registedCount;
	}

	public void setRegistedCount(int registedCount) {
		this.registedCount = registedCount;
	}

	public int calAvailableCount() {
		return inventoryCount - subscriptionedCount - registedCount;
	}

	public void register(int count) {
		registedCount += count;
	}

	public void out(Integer count) throws CarException {
		if (this.manageBarCode) {
			throw new CarException("该配件管理到条码，不能直接出库");
		}
		registedCount -= count;
		inventoryCount -= count;
	}

	public void out(String vehicleNumber, Collection<String> codes)
			throws CarException {
		if (!this.manageBarCode) {
			throw new CarException("该配件没有管理到条码，不能采用条码方式出库");
		}
		registedCount -= codes.size();
		inventoryCount -= codes.size();

		PartInstanceEntity partInstanceEntity = null;
		for (String code : codes) {
			partInstanceEntity = this.partInstanceJpaRepo.findOne(code);
			partInstanceEntity.setOUTState(vehicleNumber);
			partInstanceEntity.save();
		}

	}

	public void save() {
		partJpaRepo.save(this);

	}

	public PartSpecVO toPartSpecVO() {
		PartSpecVO partSpecVO = new PartSpecVO();
		BeanUtils.copyProperties(this, partSpecVO);
		return partSpecVO;
	}

}
