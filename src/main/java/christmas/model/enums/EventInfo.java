package christmas.model.enums;

public enum EventInfo {
    CHRISTMAS_DDAY("크리스마스 디데이 할인", "once", 100),
    WEEK_DAY("평일 할인", "desert", 2023),
    WEEK_END("주말 할인", "main", 2023),
    SPECIAL("스페셜 할인", "once", 1000),;
    private String name;
    private String type;
    private int price;

    EventInfo(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }
}
