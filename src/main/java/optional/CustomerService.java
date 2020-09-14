package optional;

import optional.model.Customer;
import optional.model.CustomerPaymentStatus;

public class CustomerService {
	private CustomerRepository repo;

	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}

	public CustomerPaymentStatus calculatePaymentStatus(Long id) {
		Customer customer = repo.read(id);

		return CustomerPaymentStatus.UNKNOWN;
	}
	

}
