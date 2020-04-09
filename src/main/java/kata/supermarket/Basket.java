package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kata.discountengine.IDiscountEngine;

public class Basket {
    private final List<Item> items;
    private IDiscountEngine discountEngine;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    public List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    public void setDiscountEngine(IDiscountEngine discountEngine) {
        this.discountEngine = discountEngine;
    }

    private class TotalCalculator {
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal discounts() {
            try {
                if(discountEngine != null) {
                    discountEngine.execute();
                    return discountEngine.calculateDiscounts();
                }
            } catch(Exception e) {
                // TODO Should handle the error
                e.printStackTrace();
            }
            return BigDecimal.ZERO;
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
