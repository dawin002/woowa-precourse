package christmas.model;

import christmas.model.enums.Menu;

import java.util.ArrayList;
import java.util.List;

public class Gifts {
    private final static int EVENT_APPLICABLE_MIN_PRICE = 10000;
    private final static int GIFT_GET_CHAMPAGNE_PRICE = 120000;
    private final static int GIFT_CHAMPAGNE_QUANTITY = 1;
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
        return totalPrice >= EVENT_APPLICABLE_MIN_PRICE;
    }

    private void checkChampagne(int totalPrice) {
        if (totalPrice >= GIFT_GET_CHAMPAGNE_PRICE) {
            String giftName = Menu.CHAMPAGNE.getName();
            Gift newGift = new Gift(giftName, GIFT_CHAMPAGNE_QUANTITY);
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
