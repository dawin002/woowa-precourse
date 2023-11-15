package christmas.model;

import christmas.model.enums.Menu;
import christmas.utils.InputParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<String> inputOrders) {
        orders = new ArrayList<>();
        for (String inputOrder : inputOrders) {
            String menu = InputParser.getMenu(inputOrder);
            int quantity = InputParser.getQuantity(inputOrder);
            Order newOrder = new Order(menu, quantity);
            orders.add(newOrder);
        }
        validateDuplicate();
        validateOnlyDrink();
        validateTotalQuantity();
    }

    private void validateDuplicate() {
        List<String> names = new ArrayList<>();
        HashSet<String> nonDuplicateNames = new HashSet<>();
        for (Order order : orders) {
            String name = order.getName();
            names.add(name);
            nonDuplicateNames.add(name);
        }
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateOnlyDrink() {
        HashSet<String> types = new HashSet<>();
        for (Order order : orders) {
            String name = order.getName();
            String type = Menu.getTypeByName(name);
            types.add(type);
        }
        if (types.size() == 1 && types.contains("drink")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateTotalQuantity() {
        int totalQuantity = 0;
        for (Order order : orders) {
            totalQuantity += order.getQuantity();
        }
        if (totalQuantity > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Order order : orders) {
            String name = order.getName();
            totalPrice += Menu.getPriceByName(name) * order.getQuantity();
        }
        return totalPrice;
    }

    public int countQuantityOfType(String type) {
        int quantityOfType = 0;
        for (Order order : orders) {
            String name = order.getName();
            if (Menu.getTypeByName(name).equals(type)) {
                quantityOfType += order.getQuantity();
            }
        }
        return quantityOfType;
    }
}
