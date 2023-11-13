package christmas.model;

public class DiscountResult {
    private String name;
    private int price;

    public DiscountResult(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
