package car.domain.inventory;

public class PartVO extends PartSpecVO {

	private int inventoryCount;

	private int availableCount;

	private int subscriptionedCount;

	private int registedCount;

	public int getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public int getSubscriptionedCount() {
		return subscriptionedCount;
	}

	public void setSubscriptionedCount(int subscriptionedCount) {
		this.subscriptionedCount = subscriptionedCount;
	}

	public int getRegistedCount() {
		return registedCount;
	}

	public void setRegistedCount(int registedCount) {
		this.registedCount = registedCount;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
}
