package service;

import christmas.model.Discount;
import christmas.model.enums.Calender;
import christmas.model.enums.DiscountInfo;

import java.util.ArrayList;
import java.util.List;

public class DiscountService {
    private final List<Discount> discounts;
    private int totalDiscountPrice;

    public DiscountService(int date, OrderService orderService) {
        this.discounts = new ArrayList<>();
        addDiscounts(date, orderService);
        this.totalDiscountPrice = setTotalDiscountPrice();
    }

    public void addDiscounts(int date, OrderService orderService) {
        if (isDiscountApplicable(orderService)) {
            checkChristmasDDayDiscount(date);
            checkWeekDayDiscount(date, orderService);
            checkWeekEndDiscount(date, orderService);
            checkSpecialDiscount(date);
        }
    }

    private boolean isDiscountApplicable(OrderService orderService) {
        return orderService.getTotalPrice() >= 10000;
    }

    public void checkChristmasDDayDiscount(int date) {
        if (isChristmasDDay(date)) {
            String discountName = DiscountInfo.CHRISTMAS_DDAY.getName();
            int totalDiscount = DiscountInfo.CHRISTMAS_DDAY.getPrice() * (date - 1) + 1000;
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    public void checkWeekDayDiscount(int date, OrderService orderService) {
        if (isWeekDay(date)) {
            String discountName = DiscountInfo.WEEK_DAY.getName();
            int discountQuantity = orderService.countQuantityOfType(DiscountInfo.WEEK_DAY.getType());
            int totalDiscount = DiscountInfo.WEEK_DAY.getPrice() * discountQuantity;
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    public void checkWeekEndDiscount(int date, OrderService orderService) {
        if (isWeekEnd(date)) {
            String discountName = DiscountInfo.WEEK_END.getName();
            int discountQuantity = orderService.countQuantityOfType(DiscountInfo.WEEK_END.getType());
            int totalDiscount = DiscountInfo.WEEK_END.getPrice() * discountQuantity;
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    public void checkSpecialDiscount(int date) {
        if (isSpecial(date)) {
            String discountName = DiscountInfo.SPECIAL.getName();
            int totalDiscount = DiscountInfo.SPECIAL.getPrice();
            discounts.add(new Discount(discountName, totalDiscount));
        }
    }

    private boolean isChristmasDDay(int date) {
        return date >= 1 && date <= 25;
    }

    private boolean isWeekDay(int date) {
        return Calender.SUNDAY.isMatch(date)
                || Calender.MONDAY.isMatch(date)
                || Calender.TUESDAY.isMatch(date)
                || Calender.WEDNESDAY.isMatch(date)
                || Calender.THURSDAY.isMatch(date);
    }

    private boolean isWeekEnd(int date) {
        return Calender.FRIDAY.isMatch(date)
                || Calender.SATURDAY.isMatch(date);
    }

    private boolean isSpecial(int date) {
        return Calender.SUNDAY.isMatch(date) || date == 25;
    }

    private int setTotalDiscountPrice() {
        int totalDiscount = 0;
        for (Discount discount : discounts) {
            totalDiscount += discount.getPrice();
        }
        return totalDiscount;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

}
