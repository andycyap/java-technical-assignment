package kata.discountengine;

import java.math.BigDecimal;
import java.util.List;

public interface IDiscountEngine {
    /**
     * 
     * @return Collection of rules for the Discount Engine to process
     */
    List<IRule> getRules();

    /**
     * Run the Discount Engine on the against the rules
     */
    void execute();

    /**
     * 
     * @return Calculated discounts that enough to offset the subtotal
     */
	BigDecimal calculateDiscounts();
}