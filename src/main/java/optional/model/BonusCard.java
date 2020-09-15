package optional.model;

public class BonusCard {

	private boolean isVipCustomer;
	private int numberOfItems;

	public BonusCard(boolean isVipCustomer, int numberOfItems) {
		this.isVipCustomer = isVipCustomer;
		this.numberOfItems = numberOfItems;
	}

	public BonusCard(int numberOfItems) {
		this.isVipCustomer = false;
		this.numberOfItems = numberOfItems;
	}

	public boolean isVipCustomer() {
		return isVipCustomer;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public void increaseNumberOfItems(int orderedItems) {
		numberOfItems += orderedItems;
	}

}
