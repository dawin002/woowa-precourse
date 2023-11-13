package christmas.model;

import christmas.model.enums.EventEnum;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private int date;
    private Orders orders;
    private boolean eventApplicable;

    public Event(int date, Orders orders, int totalPrice) {
        this.date = date;
        this.orders = orders;
        this.eventApplicable = isEventApplicable(totalPrice);
    }

    private boolean isEventApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }

    public EventResult getChristmasDDayDiscount() {
        if (!eventApplicable || !isChristmasDDay()) {
            return null;
        }
        String eventName = EventEnum.CHRISTMAS_DDAY.getName();
        int totalDiscount = EventEnum.CHRISTMAS_DDAY.getPrice() * (date - 1) + 1000;
        return new EventResult(eventName, totalDiscount);
    }

    private boolean isChristmasDDay() {
        return date >= 1 && date <= 25;
    }

    private boolean isWeekDay(int date) {

    }

}
