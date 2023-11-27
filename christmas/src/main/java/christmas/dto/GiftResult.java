package christmas.dto;

import christmas.model.Gift;

import java.util.List;

public class GiftResult {
    private final List<Gift> gifts;

    public GiftResult(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public List<Gift> getGifts() {
        return gifts;
    }
}
