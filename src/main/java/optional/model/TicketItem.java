package optional.model;

public class TicketItem {

	private Category category;

	public TicketItem(Category category) {
		this.setCategory(category);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return category.getPrice();
	}

}
