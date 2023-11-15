package christmas.model;

import christmas.model.enums.Menu;

public class Gift {
    private String name;
    private int quantity;

    public Gift(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
