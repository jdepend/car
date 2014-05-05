package car.domain.maintain;

public class RegisterItemVO {

	private String type;

	private String name;

	private String partNumber;

	private int partCount;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public int getPartCount() {
		return partCount;
	}

	public void setPartCount(int partCount) {
		this.partCount = partCount;
	}
}
