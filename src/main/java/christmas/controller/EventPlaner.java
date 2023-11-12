package christmas.controller;

import christmas.model.Date;
import christmas.model.OrdersGenerator;
import christmas.model.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlaner {
    private OutputView outputView;
    private InputView inputView;

    public EventPlaner(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        Date date = initDate();
        Orders orders = initOrders();
        printTotalPrice(orders);
    }

    private void printTotalPrice(Orders orders) {
        int totalPrice = orders.getTotalPrice();
        System.out.println(totalPrice);
    }

    private Date initDate() {
        try {
            outputView.printReadDate();
            return new Date(inputView.readDate());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return initDate();
    }

    private Orders initOrders() {
        try {
            outputView.printReadOrder();
            OrdersGenerator generator = new OrdersGenerator(inputView.readOrder());
            return new Orders(generator.getOrders());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return initOrders();
    }
}
