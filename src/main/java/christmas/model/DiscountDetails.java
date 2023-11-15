package christmas.model;

import christmas.model.enums.DiscountInfo;

import java.util.ArrayList;
import java.util.List;

public class DiscountDetails {
    private final List<Discount> discounts;

    public DiscountDetails() {
        this.discounts = new ArrayList<>();
    }

    public void addDiscount(Discount discount) {
        if (discount != null) {
            this.discounts.add(discount);
        }
    }

    public List<Discount> getDetails() {
        return discounts;
    }

    public int getTotalDiscountAmount() {
        int totalAmount = 0;
        for (Discount discount : discounts) {
            totalAmount += discount.getAmount();
        }
        return totalAmount;
    }

    public int getTotalDiscountAmountWithoutGift() {
        int totalAmount = 0;
        String giftEvent = DiscountInfo.GIFT_EVENT.getName();
        for (Discount discount : discounts) {
            if(!discount.getName().equals(giftEvent)) {
                totalAmount += discount.getAmount();
            }
        }
        return totalAmount;
    }
}
