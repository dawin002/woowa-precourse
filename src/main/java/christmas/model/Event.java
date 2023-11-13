package christmas.model;

import christmas.model.enums.Calender;
import christmas.model.enums.EventInfo;

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
        String eventName = EventInfo.CHRISTMAS_DDAY.getName();
        int totalDiscount = EventInfo.CHRISTMAS_DDAY.getPrice() * (date - 1) + 1000;
        return new EventResult(eventName, totalDiscount);
    }

    private boolean isChristmasDDay() {
        return date >= 1 && date <= 25;
    }

    public EventResult getWeekDayDiscount() {
        if (!eventApplicable || !isWeekDay()) {
            return null;
        }
        String eventName = EventInfo.WEEK_DAY.getName();
        int discountQuantity = orders.countQuantityOfType(EventInfo.WEEK_DAY.getType());
        int totalDiscount = EventInfo.WEEK_DAY.getPrice() * discountQuantity;
        return new EventResult(eventName, totalDiscount);
    }

    private boolean isWeekDay() {
        return Calender.SUNDAY.isMatch(date)
                || Calender.MONDAY.isMatch(date)
                || Calender.TUESDAY.isMatch(date)
                || Calender.WEDNESDAY.isMatch(date)
                || Calender.THURSDAY.isMatch(date);
    }

    public EventResult getWeekEndDiscount() {
        if (!eventApplicable || !isWeekEnd()) {
            return null;
        }
        String eventName = EventInfo.WEEK_END.getName();
        int discountQuantity = orders.countQuantityOfType(EventInfo.WEEK_END.getType());
        int totalDiscount = EventInfo.WEEK_END.getPrice() * discountQuantity;
        return new EventResult(eventName, totalDiscount);
    }

    private boolean isWeekEnd() {
        return Calender.FRIDAY.isMatch(date)
                || Calender.SATURDAY.isMatch(date);
    }

    public EventResult getSpecialDiscount() {
        if (!eventApplicable || !isSpecial()) {
            return null;
        }
        String eventName = EventInfo.SPECIAL.getName();
        int totalDiscount = EventInfo.SPECIAL.getPrice();
        return new EventResult(eventName, totalDiscount);
    }

    private boolean isSpecial() {
        return Calender.SUNDAY.isMatch(date) || date == 25;
    }

}
