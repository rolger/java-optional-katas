package optional.model;

import java.util.Objects;

public class Address {
	private String city;
	private String street;
	private String house;
	private String postCode;
	private Country country;

	public Address(String city, String street, String house, String postCode, Country country) {
		this.city = Objects.requireNonNull(city);
		this.street = Objects.requireNonNull(street);
		this.house = Objects.requireNonNull(house);
		this.postCode = Objects.requireNonNull(postCode);
		this.country = Objects.requireNonNull(country);
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getHouse() {
		return house;
	}

	public String getPostCode() {
		return postCode;
	}

	public Country getCountry() {
		return country;
	}

}
