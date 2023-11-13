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

    private static BadgeInfo getBadgeByAmount(int amount) {
        for (BadgeInfo badge : BadgeInfo.values()) {
            if (amount >= badge.amountRangeStart && amount < badge.amountRangeEnd) {
                return badge;
            }
        }
        throw new IllegalStateException("Cant find Badge by amount");
    }

    public static String getNameByAmount(int amount) {
        BadgeInfo badge = getBadgeByAmount(amount);
        return badge.name;
    }
}
