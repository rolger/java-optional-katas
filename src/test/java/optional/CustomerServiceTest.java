package optional;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import optional.model.BonusCard;
import optional.model.Customer;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@Mock
	private CustomerRepository repo;

	private CustomerService service;

	@BeforeEach
	public void before() throws Exception {
		service = new CustomerService(repo);
	}

	@Test
	void findVipCustomer_without_customers_in_repo() throws Exception {
		Mockito.when(repo.findAll()).thenReturn(Collections.emptyList());

		String vipCustomer = service.findVipCustomer();

		assertThat(vipCustomer).isEqualTo("NOT FOUND");
	}

	@Test
	void findVipCustomer_without_vip_customers_in_repo() throws Exception {
		Mockito.when(repo.findAll()).thenReturn(asList(new Customer(1L, "max")));

		String vipCustomer = service.findVipCustomer();

		assertThat(vipCustomer).isEqualTo("NOT FOUND");
	}

	@Test
	void findVipCustomer_with_vip_customers_in_repo() throws Exception {
		Customer customer = new Customer(1L, "max");
		customer.setBonusCard(new BonusCard(true, 0));
		Mockito.when(repo.findAll()).thenReturn(asList(customer));

		String vipCustomer = service.findVipCustomer();

		assertThat(vipCustomer).isEqualTo("max");
	}
	
	@Test
	void search_without_age() throws Exception {
//		Mockito.when(repo.findAll()).thenReturn(asList(new Customer(1L, "max")));
//
//		List<Customer> searchResult = service.search("max", null);
//
//		assertThat(searchResult).hasSize(1);
//		assertThat(searchResult.get(0).getName()).isEqualTo("max");
	}
	
	@Test
	void search_without_optional_age() throws Exception {
//		Mockito.when(repo.findAll()).thenReturn(asList(new Customer(1L, "max")));
//
//		List<Customer> searchResult = service.search("max", Optional.empty());
//
//		assertThat(searchResult).hasSize(1);
//		assertThat(searchResult.get(0).getName()).isEqualTo("max");
	}

}
