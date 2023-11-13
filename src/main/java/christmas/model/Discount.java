package christmas.model;

public class Discount {
    private String name;
    private int price;

    public Discount(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
