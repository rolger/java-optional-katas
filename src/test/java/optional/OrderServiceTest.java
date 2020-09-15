package optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import optional.model.Address;
import optional.model.Country;
import optional.model.Customer;
import optional.model.TicketCart;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

	@Mock
	private RestCountriesAPI stubRestCountriesAPI;

	private OrderService service;

	@BeforeEach
	public void before() throws Exception {
		service = new OrderService(stubRestCountriesAPI);
	}

	@Test
	public void calculateShippingFee() throws Exception {
		TicketCart cart = new TicketCart();
		cart.setCustomer(new Customer(3L, "max"));
		
		assertThat(service.calculateShippingFee(cart )).isEqualTo(0);
	}


	@Test
	public void calculateShippingFee_for_common_market() throws Exception {
		Mockito.when(stubRestCountriesAPI.isInCommonMarket(Mockito.any())).thenReturn(true);
		
		TicketCart cart = new TicketCart();
		Customer customer = new Customer(3L, "max");
		customer.setAddress(new Address("vienna", "", "", "A-1120", new Country("AT")));
		cart.setCustomer(customer);
		
		assertThat(service.calculateShippingFee(cart )).isEqualTo(5);
	}
	
	@Test
	public void calculateShippingFee_for_america() throws Exception {
		Mockito.when(stubRestCountriesAPI.isInCommonMarket(Mockito.any())).thenReturn(false);
		Mockito.when(stubRestCountriesAPI.isInAmericas(Mockito.any())).thenReturn(true);
		
		TicketCart cart = new TicketCart();
		Customer customer = new Customer(3L, "max");
		customer.setAddress(new Address("new york", "", "", "NYA40", new Country("US")));
		cart.setCustomer(customer);
		
		assertThat(service.calculateShippingFee(cart )).isEqualTo(15);
	}
	
	@Test
	public void calculateShippingFee_for_others() throws Exception {
		Mockito.when(stubRestCountriesAPI.isInCommonMarket(Mockito.any())).thenReturn(false);
		Mockito.when(stubRestCountriesAPI.isInAmericas(Mockito.any())).thenReturn(false);
		
		TicketCart cart = new TicketCart();
		Customer customer = new Customer(3L, "max");
		customer.setAddress(new Address("new york", "", "", "NYA40", new Country("US")));
		cart.setCustomer(customer);
		
		assertThat(service.calculateShippingFee(cart )).isEqualTo(25);
	}

}
