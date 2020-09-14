package optional;

import java.util.Optional;

import optional.model.TicketCart;

public class TicketCalculator {

	private TicketCart cart;

	public TicketCalculator(TicketCart cart) {
		this.cart = cart;
	}

	public Optional<Double> netPrice(String reservationNumber) {
		if (cart.findTickets(reservationNumber).isEmpty()) {
			return null;
		}

		return Optional.of(cart.findTickets(reservationNumber).stream().mapToDouble(t -> t.getPrice()).sum());
	}

	public Double grossPrice(String reservationNumber) {
		Optional<Double> netPrice = netPrice(reservationNumber);
		
		if (netPrice == null || netPrice.isEmpty()) {
			return 0.0;
		}
		
		return netPrice.get() * 0.19 + netPrice.get();
	}

}
