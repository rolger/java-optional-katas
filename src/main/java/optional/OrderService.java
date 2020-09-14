package optional;

import optional.model.TicketCart;

public class OrderService {

	private RestCountriesAPI restCountriesAPI;

	public OrderService(RestCountriesAPI restCountriesAPI) {
		this.restCountriesAPI = restCountriesAPI;
	}

	public int calculateShippingFee(TicketCart cart) {
		if (cart.getCustomer().isPresent()) {
			if (cart.getCustomer().get().getAddress() != null) {
				if (restCountriesAPI.isInCommonMarket(cart.getCustomer().get().getAddress().getCountry())) {
					return 5;
				} else if (restCountriesAPI.isInAmericas(cart.getCustomer().get().getAddress().getCountry())) {
					return 15;
				}

				return 25;
			}
		}
		return 0;
	}
	
}
