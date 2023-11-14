package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlaner {
    private OutputView outputView;
    private InputView inputView;

    public EventPlaner(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startPlaner() {
        printPlanerStart();
        Date date = initDate();
        Orders orders = initOrders();

        GiftMenu giftMenu = initGiftMenu(orders);
        DiscountService discountService = initDiscountService(orders);
        DiscountDetails discountDetails = discountService.calculateDiscounts(date, orders);
        Badge badge = initBadge(orders);

        printResultStart(date);
        printOrders(orders);
        printTotalPriceBeforeDiscount(orders);
        printGiftMenu(giftMenu);
        printDiscountDetails(discountDetails);
        printTotalPriceAfterDiscount(orders, discountDetails);
        printEventBadge(badge);
    }

    private Date initDate() {
        while (true) {
            try {
                outputView.printReadDate();
                return new Date(inputView.readDate());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Orders initOrders() {
        while (true) {
            try {
                outputView.printReadOrder();
                return new Orders(inputView.readOrder());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private GiftMenu initGiftMenu(Orders orders) {
        int totalPrice = orders.getTotalPrice();
        return new GiftMenu(totalPrice);
    }

    private DiscountService initDiscountService(Orders orders) {
        int totalPrice = orders.getTotalPrice();
        return new DiscountService(totalPrice);
    }

    private Badge initBadge(Orders orders) {
        int totalPrice = orders.getTotalPrice();
        return new Badge(totalPrice);
    }

    private void printPlanerStart() {
        outputView.printStartMessage();
    }

    private void printResultStart(Date date) {
        outputView.printStartResult(date.getDate());
    }

    private void printOrders(Orders orders) {
        outputView.printOrders(orders.getOrderResults());
    }

    private void printTotalPriceBeforeDiscount(Orders orders) {
        outputView.printTotalPriceBeforeDiscount(orders.getTotalPrice());
    }

    private void printGiftMenu(GiftMenu giftMenu) {
        outputView.printGiftMenu(giftMenu.getGiftMenu());
    }

    private void printDiscountDetails(DiscountDetails discountDetails) {
        outputView.printDiscountDetails(discountDetails.getDetails());
    }

    private void printTotalPriceAfterDiscount(Orders orders, DiscountDetails discountDetails) {
    }

    private void printEventBadge(Badge badge) {
    }
}
