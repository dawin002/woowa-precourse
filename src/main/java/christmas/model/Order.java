package christmas.model;

import christmas.model.enums.Menu;

public class Order {
    private String name;
    private int quantity;
    private String type;
    private int price;

    public Order(String name, int quantity) {
        validateOrder(name, quantity);
        this.name = name;
        this.quantity = quantity;
        this.type = Menu.getTypeByName(name);
        this.price = Menu.getPriceByName(name);
    }

    public void validateOrder(String name, int quantity) {
        if (Menu.isNotExistMenu(name)
                || quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}

