package optional.model;

import java.time.LocalDate;
import java.util.Optional;

public class Customer {
	private long id;
	private String name;
	private Optional<LocalDate> birthday;
	private Address address;

	public Customer(Long id, String name) {
		this.id = id;
		this.name = name;
		this.birthday = Optional.empty();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Optional<LocalDate> getBirthday() {
		return birthday;
	}

	public Address getAddress() {
		return address;
	}

}
