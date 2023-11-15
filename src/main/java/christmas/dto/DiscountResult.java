package christmas.dto;

import christmas.model.Discount;

import java.util.List;

public class DiscountResult {
    private final List<Discount> discounts;

    public DiscountResult(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
