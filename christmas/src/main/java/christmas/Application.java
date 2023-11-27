package christmas;

import christmas.controller.EventPlanner;
import christmas.model.DiscountService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        DiscountService discountService = new DiscountService();
        EventPlanner eventPlanner = new EventPlanner(outputView, inputView, discountService);
        eventPlanner.startPlanner();
    }
}
