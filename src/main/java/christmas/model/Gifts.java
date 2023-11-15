package christmas.model;

import christmas.model.enums.Menu;

import java.util.ArrayList;
import java.util.List;

public class Gifts {
    private final List<Gift> gifts;
    private final boolean isApplicable;

    public Gifts(int totalPrice) {
        this.gifts = new ArrayList<>();
        this.isApplicable = getApplicable(totalPrice);
        checkGifts(totalPrice);
    }

    private void checkGifts(int totalPrice) {
        if (isApplicable) {
            checkChampagne(totalPrice);
        }
    }

    private boolean getApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }

    private void checkChampagne(int totalPrice) {
        if (totalPrice >= 120000) {
            String giftName = Menu.CHAMPAGNE.getName();
            int giftQuantity = 1;
            Gift newGift = new Gift(giftName, giftQuantity);
            gifts.add(newGift);
        }
    }

    public int getGiftCount() {
        return gifts.size();
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Gift gift : gifts) {
            String giftName = gift.getName();
            totalPrice += Menu.getPriceByName(giftName);
        }
        return totalPrice;
    }
}
