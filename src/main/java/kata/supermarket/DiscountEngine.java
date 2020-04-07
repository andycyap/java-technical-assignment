package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DiscountEngine implements IDiscountEngine {

    private Basket basket;
    private List<IRule> rules;
    private BigDecimal calculatedDiscount = BigDecimal.ZERO;

    @Override
    public List<IRule> getRules() {
        if(rules == null) {
            rules = new ArrayList<IRule>();
        }
        return rules;
    }

    @Override
    public void execute() {
        for(IRule rule : rules) {
            rule.apply(basket.items());
        }
    }

    @Override
    public BigDecimal calculateDiscounts() {
        return calculatedDiscount;
    }

    void setBasket(Basket basket) {
        this.basket = basket;
    }
}