package optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import optional.model.Customer;

public class CustomerService {
	private CustomerRepository repo;

	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}

	public String findVipCustomer() {
		Optional<Customer> customer = repo.findAll().stream() //
				.filter(Customer::isVip) // 
				.findFirst();

		if (customer.isPresent()) {
			return customer.get().getName();
		}
		
		return "NOT FOUND";
	}

	public List<Customer> search(String name, Optional<Integer> age) {
		return repo.findAll().stream() //
				.filter(c -> c.getName().equals(name)) //
				.filter(c -> c.getAge().get() >= age.get()) //
				.collect(Collectors.toList());
	}

}
