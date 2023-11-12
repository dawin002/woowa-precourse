package christmas.controller;

import christmas.model.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlaner {
    OutputView outputView;
    InputView inputView;
    Date date;
    public EventPlaner(OutputView outputView, InputView inputView) {
        this.date = initDate();
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {

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
}
