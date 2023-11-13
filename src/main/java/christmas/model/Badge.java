package christmas.model;

import christmas.model.enums.BadgeInfo;

public class Badge {
    private String name;

    public Badge(int discountAmount) {
        this.name = null;
    }
    public void setBadge(int discountAmount) {
        for (BadgeInfo badge : BadgeInfo.values()) {
            if (badge.isAmountInRange(discountAmount)) {
                this.name = badge.getName();
            }
        }
    }

    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        throw new IllegalStateException("Badge name is null(call setBadge() function first).");
    }
}
