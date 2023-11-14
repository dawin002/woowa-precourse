package christmas.model;

import christmas.model.enums.Menu;

public class Order {
    private String name;
    private int quantity;

    public Order(String name, int quantity) {
        validateOrder(name, quantity);
        this.name = name;
        this.quantity = quantity;
    }

    public void validateOrder(String name, int quantity) {
        if (Menu.isNotExistMenu(name)
                || quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

