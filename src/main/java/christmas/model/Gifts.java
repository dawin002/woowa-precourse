package christmas.model;

import christmas.model.enums.Menu;

import java.util.ArrayList;
import java.util.List;

public class Gifts {
    private List<Gift> gifts;
    private boolean isApplicable;

    public Gifts(int totalPrice) {
        this.gifts = new ArrayList<>();
        this.isApplicable = getApplicable(totalPrice);
        checkGifts(totalPrice);
    }

    private boolean getApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }

    private void checkGifts(int totalPrice) {
        if (isApplicable) {
            checkChampagne(totalPrice);
        }
    }

    private void checkChampagne(int totalPrice) {
        if (totalPrice >= 120000) {
            String giftName = Menu.CHAMPAGNE.getName();
            int giftPrice = Menu.getPriceByName(giftName);
            Gift newGift = new Gift(giftName, giftPrice);
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
