package christmas.model;

import christmas.model.enums.Menu;

public class Order {
    private final static int ORDER_MIN_QUANTITY = 1;
    private final static String ERROR_NOT_EXIST_MENU = "no such food name in Menu enum.";
    private final static String ERROR_QUANTITY_LESS_THAN_ONE = "order quantity is less than 1.";
    private final String name;
    private final int quantity;

    public Order(String name, int quantity) {
        validateOrder(name, quantity);
        this.name = name;
        this.quantity = quantity;
    }

    public void validateOrder(String name, int quantity) {
        if (Menu.isNotExistMenu(name)) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_MENU);
        }
        if (quantity < ORDER_MIN_QUANTITY) {
            throw new IllegalArgumentException(ERROR_QUANTITY_LESS_THAN_ONE);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

