package christmas.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Orders {
    private List<Order> orders;

    public Orders(List<String> inputOrders) {
        orders = new ArrayList<>();
        for (String inputOrder : inputOrders) {
            Order newOrder = initOrder(inputOrder);
            orders.add(newOrder);
        }
        validateDuplicate();
        validateOnlyDrink();
        validateTotalQuantity();
    }

    private Order initOrder(String inputOrder) {
        String[] splitOrder = inputOrder.split("-");
        String menu = splitOrder[0];
        int quantity = Integer.parseInt(splitOrder[1]);
        return new Order(menu, quantity);
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
            types.add(order.getType());
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
        return this.orders;
    }
}
