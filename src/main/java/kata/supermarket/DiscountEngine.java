package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import kata.discountengine.IDiscountEngine;
import kata.discountengine.IRule;

public class DiscountEngine implements IDiscountEngine {

    private List<IRule> rules;
    private BigDecimal calculatedDiscount = BigDecimal.ZERO;
    private Basket basket;

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
            rule.setSomething(basket);
            rule.apply();
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