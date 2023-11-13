package service;

import christmas.model.Date;
import christmas.model.Discount;
import christmas.model.enums.Calender;
import christmas.model.enums.DiscountInfo;

import java.util.ArrayList;
import java.util.List;

public class DiscountService {
    private final int visitDate;
    private final OrderService orderService;
    private final List<Discount> discounts;

    public DiscountService(Date date, OrderService orderService) {
        this.visitDate = date.getDate();
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
            int totalDiscount = DiscountInfo.CHRISTMAS_DDAY.getPrice() * (visitDate - 1) + 1000;
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
        return visitDate >= 1 && visitDate <= 25;
    }

    private boolean isWeekDay() {
        return Calender.SUNDAY.isMatch(visitDate)
                || Calender.MONDAY.isMatch(visitDate)
                || Calender.TUESDAY.isMatch(visitDate)
                || Calender.WEDNESDAY.isMatch(visitDate)
                || Calender.THURSDAY.isMatch(visitDate);
    }

    private boolean isWeekEnd() {
        return Calender.FRIDAY.isMatch(visitDate)
                || Calender.SATURDAY.isMatch(visitDate);
    }

    private boolean isSpecial() {
        return Calender.SUNDAY.isMatch(visitDate) || visitDate == 25;
    }

    public int getTotalDiscount() {
        int totalDiscount = 0;
        for (Discount discount : discounts) {
            totalDiscount += discount.getPrice();
        }
        return totalDiscount;
    }

}
