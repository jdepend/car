package car.domain.maintain.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import car.domain.inventory.InVentoryFacade;
import car.domain.inventory.PartSpecVO;

@Entity
@Table(name = "maintain_register_item")
public class RegisterItemEntity {

	private String id;

	private RegisterEntity register;

	private String name;

	private RegisterItemTypeEntity type;

	private PartSpecVO partSpec;

	private int partCount;

	@Autowired
	private RegisterItemJpaRepo registerItemJpaRepo;

	@Autowired
	private RegisterItemTypeService registerItemTypeService;

	@Autowired
	private InVentoryFacade inVentoryFacade;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegisterId() {
		return register.getId();
	}

	public void setRegisterId(String registerId) {
		if (this.register != null) {
			this.register.setId(registerId);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type.getType();
	}

	public void setType(String type) {
		this.type = registerItemTypeService.obtain(type);
	}

	@Column(name = "part_number")
	public String getPartNumber() {
		return partSpec.getNumber();
	}

	public void setPartNumber(String partNumber) {
		this.partSpec = inVentoryFacade.obtainPartSpec(partNumber);
	}

	@Column(name = "part_count")
	public int getPartCount() {
		return partCount;
	}

	public void setPartCount(int partCount) {
		this.partCount = partCount;
	}

	public boolean needPart() {
		return this.partSpec != null && this.partCount > 0;
	}

	public PartSpecVO obtainPartSpec() {
		return this.partSpec;
	}

	void setRegister(RegisterEntity register) {
		this.register = register;
	}

	public RegisterItemTypeEntity obtainType() {
		return this.type;
	}

	public void save() {
		registerItemJpaRepo.save(this);
	}
}
