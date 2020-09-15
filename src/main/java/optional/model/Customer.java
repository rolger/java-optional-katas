package optional.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class Customer {
	private long id;
	private String name;
	private Optional<LocalDate> birthday;
	private Address address;
	private BonusCard bonusCard;

	public Customer(Long id, String name) {
		this.id = id;
		this.name = Objects.requireNonNull(name);
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

	public void setBirthday(Optional<LocalDate> birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BonusCard getBonusCard() {
		return bonusCard;
	}

	public void setBonusCard(BonusCard bonusCard) {
		this.bonusCard = bonusCard;
	}

	public boolean isVip() {
		if (bonusCard != null) {
			return bonusCard.isVipCustomer();
		}
		return false;
	}

	public Optional<Integer> getAge() {
		if (birthday.isPresent()) {
			return Optional.of(LocalDate.now().getYear() - birthday.get().getYear());
		}

		return Optional.empty();
	}

}
