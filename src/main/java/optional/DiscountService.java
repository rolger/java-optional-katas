package optional;

import optional.model.BonusCard;
import optional.model.Customer;

public class DiscountService {

	public String formatDiscount(Customer customer) {
		return "Discount in % " + computeDiscountPercentage(customer.getBonusCard());
	}
	
	private Integer computeDiscountPercentage(BonusCard bonusCard) {
		if (bonusCard == null) {
			return null;
		}
		
		if (bonusCard.isVipCustomer()) {
			return 15;
		}

		if (bonusCard.getNumberOfItems() >= 10) {
			return 3;
		}
		return null;
	}
	
}
