package kata.supermarket;

import kata.discountengine.IRule;

public class BuyOneGetOneFreeRule implements IRule {
    Object t;
    private Item applicableItem;

    public BuyOneGetOneFreeRule(Item applicableItem) {
        this.applicableItem = applicableItem;
    }

    @Override
    public void apply() {
        if (t != null) {
            if (t instanceof Basket) {
                Basket basket = (Basket)t;
                for (Item item : basket.items()) {
                    if (item instanceof BuyOneGetOneFreeRule) {
                        if (item instanceof ItemByUnit) {
                            try {
                                basket.items().add((Item) ((ItemByUnit) item).clone());
                            } catch (CloneNotSupportedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        if (item instanceof ItemByWeight) {
                            try {
                                basket.items().add((Item) ((ItemByWeight) item).clone());
                            } catch (CloneNotSupportedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }                    
                        }
                    }
                }
            }
        }
    }

    @Override
    public <T> void setSomething(T t) {
        this.t = t;
    }
}