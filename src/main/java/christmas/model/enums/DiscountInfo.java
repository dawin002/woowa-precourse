package christmas.model.enums;

public enum DiscountInfo {
    CHRISTMAS_DDAY("크리스마스 디데이 할인", "once", 100),
    WEEK_DAY("평일 할인", "dessert", 2023),
    WEEK_END("주말 할인", "main", 2023),
    SPECIAL("스페셜 할인", "once", 1000),
    GIFT_EVENT("증정 이벤트", "gift", 0);
    private final String name;
    private final String type;
    private final int price;

    DiscountInfo(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }
}
