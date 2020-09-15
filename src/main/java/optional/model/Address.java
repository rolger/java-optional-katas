package optional.model;

public class Address {
	private String city;
	private String street;
	private String house;
	private String postCode;
	private Country country;

	public Address(String city, String street, String house, String postCode, Country country) {
		super();
		this.city = city;
		this.street = street;
		this.house = house;
		this.postCode = postCode;
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

}
