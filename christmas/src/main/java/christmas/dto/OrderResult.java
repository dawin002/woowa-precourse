package christmas.dto;

import christmas.model.Order;

import java.util.List;

public class OrderResult {
    private final List<Order> orders;

    public OrderResult(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
