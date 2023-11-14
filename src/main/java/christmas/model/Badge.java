package christmas.model;

import christmas.model.enums.BadgeInfo;

public class Badge {
    private String name;

    public Badge(int discountAmount) {
        this.name = setBadge(discountAmount);
    }

    public String setBadge(int discountAmount) {
        for (BadgeInfo badge : BadgeInfo.values()) {
            if (badge.isAmountInRange(discountAmount)) {
                return badge.getName();
            }
        }
        return null;
    }

    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        throw new IllegalStateException("Badge name is null(call setBadge() function first).");
    }
}
