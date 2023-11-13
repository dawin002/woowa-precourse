package christmas.model;

public class Discount {
    private String name;
    private int amount;

    public Discount(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }
}
