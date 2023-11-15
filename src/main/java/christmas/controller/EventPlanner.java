package christmas.controller;

import christmas.dto.DiscountResult;
import christmas.dto.GiftResult;
import christmas.dto.OrderResult;
import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private final OutputView outputView;
    private final InputView inputView;
    private final DiscountService discountService;

    public EventPlanner(OutputView outputView, InputView inputView, DiscountService discountService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.discountService = discountService;
    }

    public void startPlanner() {
        outputView.printStartMessage();

        Date date = initDate();
        Orders orders = initOrders();

        outputView.printStartResult(date.getDate());
        printOrdersInfo(orders);

        Gifts gifts = processGifts(orders);
        DiscountDetails discountDetails = processDiscount(date, orders, gifts);

        printTotalPriceInfo(orders, discountDetails);
        printBadge(discountDetails);
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

    private Gifts processGifts(Orders orders) {
        Gifts gifts = new Gifts(orders.getTotalPrice());
        GiftResult giftResult = new GiftResult(gifts.getGifts());
        outputView.printGiftMenu(giftResult);
        return gifts;
    }

    private DiscountDetails processDiscount(Date date, Orders orders, Gifts gifts) {
        DiscountDetails discountDetails = discountService.calculateDiscounts(date, orders, gifts);
        DiscountResult discountResult = new DiscountResult(discountDetails.getDetails());
        outputView.printDiscountDetails(discountResult);
        return discountDetails;
    }

    private void printOrdersInfo(Orders orders) {
        OrderResult orderResult = new OrderResult(orders.getOrders());
        outputView.printOrders(orderResult);
        outputView.printTotalPriceBeforeDiscount(orders.getTotalPrice());
    }

    private void printTotalPriceInfo(Orders orders, DiscountDetails discountDetails) {
        outputView.printTotalDiscountAmount(discountDetails.getTotalDiscountAmount());

        int totalPriceAfterDiscount = orders.getTotalPrice() - discountDetails.getTotalDiscountAmountWithoutGift();
        outputView.printTotalPriceAfterDiscount(totalPriceAfterDiscount);
    }

    private void printBadge(DiscountDetails discountDetails) {
        Badge badge = new Badge(discountDetails.getTotalDiscountAmount());
        outputView.printEventBadge(badge.getName());
    }

}
