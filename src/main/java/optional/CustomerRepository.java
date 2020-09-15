package optional;

import java.util.List;

import optional.model.Customer;

public interface CustomerRepository {

	public List<Customer> findAll();
	
}
