package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class EventResult {
    private List<Discount> discounts;

    public EventResult() {
        discounts = new ArrayList<>();
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public int getTotalDiscount() {
        int totalDiscount = 0;
        for (Discount discount : discounts) {
            totalDiscount += discount.getPrice();
        }
        return totalDiscount;
    }


}
