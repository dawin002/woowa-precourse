package christmas.model.enums;

import christmas.model.Badge;

public enum BadgeInfo {
    NONE("없음", 0, 5000),
    STAR("별", 5000, 10000),
    TREE("트리", 10000, 20000),
    SANTA("산타", 20000, 99999999);

    private final String name;
    private final int amountRangeStart;
    private final int amountRangeEnd;

    BadgeInfo(String name, int amountRangeStart, int amountRangeEnd) {
        this.name = name;
        this.amountRangeStart = amountRangeStart;
        this.amountRangeEnd = amountRangeEnd;
    }

    public boolean isAmountInRange(int amount) {
        return amount >= this.amountRangeStart && amount < this.amountRangeEnd;
    }

    public String getName() {
        return this.name;
    }
}
