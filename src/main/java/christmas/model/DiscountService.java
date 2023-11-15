package christmas.model;

import christmas.model.enums.DayOfWeek;
import christmas.model.enums.DiscountInfo;

public class DiscountService {
    public DiscountService() {
    }

    public DiscountDetails calculateDiscounts(Date date, Orders orders, Gifts gifts) {
        DiscountDetails discountDetails = new DiscountDetails();
        int visitDate = date.getDate();
        if(isDiscountApplicable(orders.getTotalPrice())) {
            checkChristmasDDayDiscount(discountDetails, visitDate);
            checkWeekDayDiscount(discountDetails, visitDate, orders);
            checkWeekEndDiscount(discountDetails, visitDate, orders);
            checkSpecialDiscount(discountDetails, visitDate);
            checkGiftDiscount(discountDetails, gifts);
        }
        return discountDetails;
    }

    private boolean isDiscountApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }

    private void checkChristmasDDayDiscount(DiscountDetails discountDetails, int date) {
        if (isChristmasDDay(date)) {
            String discountName = DiscountInfo.CHRISTMAS_DDAY.getName();
            int discountAmount = DiscountInfo.CHRISTMAS_DDAY.getAmount() * (date - 1) + 1000;
            discountDetails.addDiscount(new Discount(discountName, discountAmount));
        }
    }

    private void checkWeekDayDiscount(DiscountDetails discountDetails, int date, Orders orders) {
        int discountQuantity = orders.countQuantityOfType(DiscountInfo.WEEK_DAY.getType());
        if (isWeekDay(date) && discountQuantity != 0) {
            String discountName = DiscountInfo.WEEK_DAY.getName();
            int discountAmount = DiscountInfo.WEEK_DAY.getAmount() * discountQuantity;
            discountDetails.addDiscount(new Discount(discountName, discountAmount));
        }
    }

    private void checkWeekEndDiscount(DiscountDetails discountDetails, int date, Orders orders) {
        int discountQuantity = orders.countQuantityOfType(DiscountInfo.WEEK_END.getType());
        if (isWeekEnd(date) && discountQuantity != 0) {
            String discountName = DiscountInfo.WEEK_END.getName();
            int discountAmount = DiscountInfo.WEEK_END.getAmount() * discountQuantity;
            discountDetails.addDiscount(new Discount(discountName, discountAmount));
        }
    }

    private void checkSpecialDiscount(DiscountDetails discountDetails, int date) {
        if (isSpecial(date)) {
            String discountName = DiscountInfo.SPECIAL.getName();
            int discountAmount = DiscountInfo.SPECIAL.getAmount();
            discountDetails.addDiscount(new Discount(discountName, discountAmount));
        }
    }

    private void checkGiftDiscount(DiscountDetails discountDetails, Gifts gifts) {
        if (isGiftDiscount(gifts)) {
            String discountName = DiscountInfo.GIFT_EVENT.getName();
            int discountAmount = gifts.getTotalPrice();
            discountDetails.addDiscount(new Discount(discountName, discountAmount));
        }
    }

    private boolean isChristmasDDay(int date) {
        return date >= 1 && date <= 25;
    }

    private boolean isWeekDay(int date) {
        DayOfWeek day = DayOfWeek.getDayByDate(date);
        return DayOfWeek.SUNDAY == day
                || DayOfWeek.MONDAY == day
                || DayOfWeek.TUESDAY == day
                || DayOfWeek.WEDNESDAY == day
                || DayOfWeek.THURSDAY == day;
    }

    private boolean isWeekEnd(int date) {
        DayOfWeek day = DayOfWeek.getDayByDate(date);
        return DayOfWeek.FRIDAY == day
                || DayOfWeek.SATURDAY == day;
    }

    private boolean isSpecial(int date) {
        return DayOfWeek.SUNDAY == DayOfWeek.getDayByDate(date)
                || date == 25;
    }

    private boolean isGiftDiscount(Gifts gifts) {
        return gifts.getGiftCount() != 0;
    }
}
