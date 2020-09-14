package optional.model;

public enum Category {
	A(98.50), B(72.0), C(49.50);

	private double price;

	private Category(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

}
