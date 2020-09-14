package optional;

import java.util.HashMap;
import java.util.Map;

import optional.model.Customer;

public class CustomerRepository {
	private Map<Long, Customer> customerRepo = new HashMap<>();
	
	public Customer read(Long id) {
		return customerRepo.get(id);
	}

	public Customer create(String name) {
		Customer customer = new Customer(nextId(), name);
		
		return customerRepo.put(customer.getId(), customer);
	}
	
	private Long nextId() {
		return Long.valueOf(customerRepo.values().size());
	}
}
