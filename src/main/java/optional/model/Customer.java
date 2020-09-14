package optional.model;

import java.time.LocalDate;


public class Customer {
	private String name;
    private LocalDate birthday;
	private Address address;

	public Address getAddress() {
		return address;
	}

}
