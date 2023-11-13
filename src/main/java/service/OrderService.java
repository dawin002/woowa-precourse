package service;

import christmas.model.Order;

import java.util.List;

public class OrderService {
    private List<Order> orders;

    public OrderService(List<Order> orders) {
        this.orders = orders;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Order order : orders) {
            totalPrice += order.getTotalPrice();
        }
        return totalPrice;
    }


    public int countQuantityOfType(String type) {
        int quantityOfType = 0;
        for (Order order : orders) {
            if (order.isTypeMatch(type)) {
                quantityOfType += order.getQuantity();
            }
        }
        return quantityOfType;
    }
}
