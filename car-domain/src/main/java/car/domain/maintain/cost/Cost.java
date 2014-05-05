package car.domain.maintain.cost;

public class Cost {

	private Float manualPrice;

	private Float partPrice;

	public Cost() {

	}

	public Cost(Float manualPrice, Float partPrice) {
		super();
		this.manualPrice = manualPrice;
		this.partPrice = partPrice;
	}

	public Float getManualPrice() {
		return manualPrice;
	}

	public void setManualPrice(Float manualPrice) {
		this.manualPrice = manualPrice;
	}

	public Float getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(Float partPrice) {
		this.partPrice = partPrice;
	}

	public Float getPrice() {
		return this.manualPrice + this.partPrice;
	}

}
