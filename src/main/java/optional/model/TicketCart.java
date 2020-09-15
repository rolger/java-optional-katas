package optional.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TicketCart {
	private Map<String, List<TicketItem>> tickets = new HashMap<String, List<TicketItem>>();
	private Customer customer;

	public Optional<Customer> getCustomer() {
		return Optional.of(customer);
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addTicket(String reservationNumber, Category category) {
		tickets.putIfAbsent(reservationNumber, new ArrayList<>());
		tickets.get(reservationNumber).add(new TicketItem(category));
	}

	public List<TicketItem> findTickets(String reservationNumber) {
		return Optional.ofNullable(tickets.get(reservationNumber)) //
				.map(reservedTickets -> Collections.unmodifiableList(reservedTickets)) //
				.orElse(Collections.emptyList());
	}

}
