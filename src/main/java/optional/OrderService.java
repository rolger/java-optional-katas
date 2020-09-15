package optional;

import optional.model.TicketCart;

public class OrderService {

	private RestCountriesAPI restCountriesAPI;

	public OrderService(RestCountriesAPI restCountriesAPI) {
		this.restCountriesAPI = restCountriesAPI;
	}

	public int calculateShippingFee(TicketCart cart) {
		if (cart.getCustomer()!= null) {
			if (cart.getCustomer().getAddress() != null) {
				if (restCountriesAPI.isInCommonMarket(cart.getCustomer().getAddress().getCountry())) {
					return 5;
				} else if (restCountriesAPI.isInAmericas(cart.getCustomer().getAddress().getCountry())) {
					return 15;
				}

				return 25;
			}
		}
		return 0;
	}
	
}
