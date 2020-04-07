package kata.supermarket;

import java.util.ArrayList;
import java.util.List;

import kata.supermarket.IRule;

public class BuyOneGetOneFreeRule implements IRule {

    public BuyOneGetOneFreeRule() {

    }

    @Override
    public void apply(Basket basket) {
        for(Item applicableItem : basket.items()) {
            if(applicableItem instanceof BuyOneGetOneFreeRule) {
                // TODO need to create a new item with zero price
                basket.items().add(applicableItem);
            }
        }
    }


}