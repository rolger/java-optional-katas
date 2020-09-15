package optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import optional.model.BonusCard;
import optional.model.Customer;

/**
 * @author Roland.Germ
 */
public class DiscountServiceTest {

	@Test
	public void discount_for_VIP_customer() throws Exception {
		Customer customer = new Customer(5L, "max");
		customer.setBonusCard(new BonusCard(true, 0));

		String result = new DiscountService().formatDiscount(customer);

		assertThat(result).endsWith("15");
	}

	@Test
	public void discount_for_customer_with_many_items_bought() throws Exception {
		Customer customer = new Customer(5L, "max");
		customer.setBonusCard(new BonusCard(false, 110));

		String result = new DiscountService().formatDiscount(customer);

		assertThat(result).endsWith("3");
	}

	@Test
	public void no_discount_if_not_vip_and_few_items() throws Exception {
		Customer customer = new Customer(5L, "max");
		customer.setBonusCard(new BonusCard(false, 2));

		String result = new DiscountService().formatDiscount(customer);

		assertThat(result).endsWith("null");
	}

	@Test
	public void no_discount_if_no_bonuscard() throws Exception {
		Customer customer = new Customer(5L, "max");

		String result = new DiscountService().formatDiscount(customer);

		assertThat(result).endsWith("null");
	}

}
