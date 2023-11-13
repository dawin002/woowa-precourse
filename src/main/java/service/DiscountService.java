package service;

import christmas.model.Discount;
import christmas.model.enums.Calender;
import christmas.model.enums.DiscountInfo;

public class DiscountService {
    private int date;
    private OrderService orderService;
    private boolean discountApplicable;

    public DiscountService(int date, OrderService orderService, int totalPrice) {
        this.date = date;
        this.orderService = orderService;
        this.discountApplicable = isDiscountApplicable(totalPrice);
    }

    private boolean isDiscountApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }

    public Discount getChristmasDDayDiscount() {
        if (!discountApplicable || !isChristmasDDay()) {
            return null;
        }
        String discountName = DiscountInfo.CHRISTMAS_DDAY.getName();
        int totalDiscount = DiscountInfo.CHRISTMAS_DDAY.getPrice() * (date - 1) + 1000;
        return new Discount(discountName, totalDiscount);
    }

    private boolean isChristmasDDay() {
        return date >= 1 && date <= 25;
    }

    public Discount getWeekDayDiscount() {
        if (!discountApplicable || !isWeekDay()) {
            return null;
        }
        String discountName = DiscountInfo.WEEK_DAY.getName();
        int discountQuantity = orderService.countQuantityOfType(DiscountInfo.WEEK_DAY.getType());
        int totalDiscount = DiscountInfo.WEEK_DAY.getPrice() * discountQuantity;
        return new Discount(discountName, totalDiscount);
    }

    private boolean isWeekDay() {
        return Calender.SUNDAY.isMatch(date)
                || Calender.MONDAY.isMatch(date)
                || Calender.TUESDAY.isMatch(date)
                || Calender.WEDNESDAY.isMatch(date)
                || Calender.THURSDAY.isMatch(date);
    }

    public Discount getWeekEndDiscount() {
        if (!discountApplicable || !isWeekEnd()) {
            return null;
        }
        String discountName = DiscountInfo.WEEK_END.getName();
        int discountQuantity = orderService.countQuantityOfType(DiscountInfo.WEEK_END.getType());
        int totalDiscount = DiscountInfo.WEEK_END.getPrice() * discountQuantity;
        return new Discount(discountName, totalDiscount);
    }

    private boolean isWeekEnd() {
        return Calender.FRIDAY.isMatch(date)
                || Calender.SATURDAY.isMatch(date);
    }

    public Discount getSpecialDiscount() {
        if (!discountApplicable || !isSpecial()) {
            return null;
        }
        String discountName = DiscountInfo.SPECIAL.getName();
        int totalDiscount = DiscountInfo.SPECIAL.getPrice();
        return new Discount(discountName, totalDiscount);
    }

    private boolean isSpecial() {
        return Calender.SUNDAY.isMatch(date) || date == 25;
    }

}
