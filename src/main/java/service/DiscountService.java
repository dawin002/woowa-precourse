package service;

import christmas.model.Discount;
import christmas.model.enums.Calender;
import christmas.model.enums.DiscountInfo;

import java.util.ArrayList;
import java.util.List;

public class DiscountService {
    private int date;
    private OrderService orderService;
    private List<Discount> discounts;

    public DiscountService(int date, OrderService orderService) {
        this.date = date;
        this.orderService = orderService;
        this.discounts = new ArrayList<>();
        checkDiscounts();
    }

    private void checkDiscounts() {
        if (isDiscountApplicable()) {
            checkChristmasDDayDiscount();
            checkWeekDayDiscount();
            checkWeekDayDiscount();
            checkSpecialDiscount();
        }
    }

    private boolean isDiscountApplicable() {
        return orderService.getTotalPrice() >= 10000;
    }

    public void checkChristmasDDayDiscount() {
        if (isChristmasDDay()) {
            String discountName = DiscountInfo.CHRISTMAS_DDAY.getName();
            int totalDiscount = DiscountInfo.CHRISTMAS_DDAY.getPrice() * (date - 1) + 1000;
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    public void checkWeekDayDiscount() {
        if (isWeekDay()) {
            String discountName = DiscountInfo.WEEK_DAY.getName();
            int discountQuantity = orderService.countQuantityOfType(DiscountInfo.WEEK_DAY.getType());
            int totalDiscount = DiscountInfo.WEEK_DAY.getPrice() * discountQuantity;
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    public void checkWeekEndDiscount() {
        if (isWeekEnd()) {
            String discountName = DiscountInfo.WEEK_END.getName();
            int discountQuantity = orderService.countQuantityOfType(DiscountInfo.WEEK_END.getType());
            int totalDiscount = DiscountInfo.WEEK_END.getPrice() * discountQuantity;
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    public void checkSpecialDiscount() {
        if (isSpecial()) {
            String discountName = DiscountInfo.SPECIAL.getName();
            int totalDiscount = DiscountInfo.SPECIAL.getPrice();
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    private boolean isChristmasDDay() {
        return date >= 1 && date <= 25;
    }

    private boolean isWeekDay() {
        return Calender.SUNDAY.isMatch(date)
                || Calender.MONDAY.isMatch(date)
                || Calender.TUESDAY.isMatch(date)
                || Calender.WEDNESDAY.isMatch(date)
                || Calender.THURSDAY.isMatch(date);
    }

    private boolean isWeekEnd() {
        return Calender.FRIDAY.isMatch(date)
                || Calender.SATURDAY.isMatch(date);
    }

    private boolean isSpecial() {
        return Calender.SUNDAY.isMatch(date) || date == 25;
    }

}
