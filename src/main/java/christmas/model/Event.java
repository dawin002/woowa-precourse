package christmas.model;

public class Event {

    private int date;
    private Orders orders;
    private boolean eventApplicable;

    public Event(int date, Orders orders) {
        this.date = date;
        this.orders = orders;
        this.eventApplicable = isEventApplicable(orders.getTotalPrice());
    }

    public boolean isEventApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }

}
