package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class EventResult {
    private List<DiscountResult> discountResults;

    public EventResult() {
        discountResults = new ArrayList<>();
    }

    public void addDiscount(DiscountResult discount) {
        discountResults.add(discount);
    }

    public int getTotalDiscount() {
        int totalDiscount = 0;
        for (DiscountResult discount : discountResults) {
            totalDiscount += discount.getPrice();
        }
        return totalDiscount;
    }
}
