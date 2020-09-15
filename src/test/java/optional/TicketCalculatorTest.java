package optional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import optional.model.Category;
import optional.model.TicketCart;
import optional.model.TicketItem;

/**
 * @author Roland.Germ
 */
@ExtendWith(MockitoExtension.class)
public class TicketCalculatorTest {

	@Mock
	private TicketCart stubCart;

	private TicketCalculator calculator;

	@BeforeEach
	public void before() throws Exception {
		calculator = new TicketCalculator(stubCart);
	}

	@Test
	public void netPrice_should_be_0_when_cart_is_empty() throws Exception {
		Mockito.when(stubCart.findTickets("#1")).thenReturn(Collections.emptyList());
		
		assertThat(calculator.netPrice("#1")).isNull();
	}

	@Test
	public void netPrice_should_be_sum_of_items() throws Exception {
		Mockito.when(stubCart.findTickets("#1"))
				.thenReturn(Arrays.asList(aTicketWithCategoryC(), aTicketWithCategoryB(), aTicketWithCategoryA()));
		
		assertThat(calculator.netPrice("#1")).isEqualTo(Optional.of(220.0));
	}

	private TicketItem aTicketWithCategoryC() {
		return new TicketItem(Category.C);
	}

	private TicketItem aTicketWithCategoryB() {
		return new TicketItem(Category.B);
	}

	private TicketItem aTicketWithCategoryA() {
		return new TicketItem(Category.A);
	}

}
