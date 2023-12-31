package christmas.model;

import christmas.model.enums.Menu;
import christmas.utils.InputParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Orders {
    private final static int JUST_SINGLE_TYPE = 1;
    private final static String DRINK_TYPE = "drink";
    private final static int MAX_ORDER_QUANTITY = 20;
    private final static String ERROR_DUPLICATED_MENU_NAME = "Order has duplicated menu.";
    private final static String ERROR_ONLY_DRINK_TYPE = "Can not order only drink menu.";
    private final static String ERROR_OVER_MAX_QUANTITY = "Order quantity overed max quantity(20).";
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
            throw new IllegalArgumentException(ERROR_DUPLICATED_MENU_NAME);
        }
    }

    private void validateOnlyDrink() {
        HashSet<String> types = new HashSet<>();
        for (Order order : orders) {
            String name = order.getName();
            String type = Menu.getTypeByName(name);
            types.add(type);
        }
        if (types.size() == JUST_SINGLE_TYPE && types.contains(DRINK_TYPE)) {
            throw new IllegalArgumentException(ERROR_ONLY_DRINK_TYPE);
        }
    }

    private void validateTotalQuantity() {
        int totalQuantity = 0;
        for (Order order : orders) {
            totalQuantity += order.getQuantity();
        }
        if (totalQuantity > MAX_ORDER_QUANTITY) {
            throw new IllegalArgumentException(ERROR_OVER_MAX_QUANTITY);
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
