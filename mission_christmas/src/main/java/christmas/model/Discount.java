package christmas.model;

public class Discount {
    private final String name;
    private final int amount;

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
