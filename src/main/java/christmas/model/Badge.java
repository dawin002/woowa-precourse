package christmas.model;

import christmas.model.enums.BadgeInfo;

public class Badge {
    private final String name;

    public Badge(int discountAmount) {
        this.name = setBadge(discountAmount);
    }

    private String setBadge(int discountAmount) {
        return BadgeInfo.getNameByAmount(discountAmount);
    }

    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        throw new IllegalStateException("Badge name is null.(Call setBadge() function first)");
    }
}
