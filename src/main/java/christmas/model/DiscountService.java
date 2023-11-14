package christmas.model;

import christmas.model.enums.Calender;
import christmas.model.enums.DiscountInfo;
import christmas.model.enums.Menu;

public class DiscountService {
    private final boolean discountApplicable;
    public DiscountService(int totalPrice) {
        this.discountApplicable = isDiscountApplicable(totalPrice);
    }

    public DiscountDetails calculateDiscounts(Date date, Orders orders, GiftMenu gift) {
        DiscountDetails discountDetails = new DiscountDetails();
        int visitDate = date.getDate();
        if(discountApplicable) {
            discountDetails.addDiscount(getChristmasDDayDiscount(visitDate));
            discountDetails.addDiscount(getWeekDayDiscount(visitDate, orders));
            discountDetails.addDiscount(getWeekEndDiscount(visitDate, orders));
            discountDetails.addDiscount(getSpecialDiscount(visitDate));
            discountDetails.addDiscount(getGiftDiscount(gift));
        }
        return discountDetails;
    }

    private boolean isDiscountApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }

    private Discount getChristmasDDayDiscount(int date) {
        if (isChristmasDDay(date)) {
            String discountName = DiscountInfo.CHRISTMAS_DDAY.getName();
            int discountAmount = DiscountInfo.CHRISTMAS_DDAY.getAmount() * (date - 1) + 1000;
            return new Discount(discountName, discountAmount);
        }
        return null;
    }

    private Discount getWeekDayDiscount(int date, Orders orders) {
        if (isWeekDay(date)) {
            String discountName = DiscountInfo.WEEK_DAY.getName();
            int discountQuantity = orders.countQuantityOfType(DiscountInfo.WEEK_DAY.getType());
            int discountAmount = DiscountInfo.WEEK_DAY.getAmount() * discountQuantity;
            return new Discount(discountName, discountAmount);
        }
        return null;
    }

    private Discount getWeekEndDiscount(int date, Orders orders) {
        if (isWeekEnd(date)) {
            String discountName = DiscountInfo.WEEK_END.getName();
            int discountQuantity = orders.countQuantityOfType(DiscountInfo.WEEK_END.getType());
            int discountAmount = DiscountInfo.WEEK_END.getAmount() * discountQuantity;
            return new Discount(discountName, discountAmount);
        }
        return null;
    }

    private Discount getSpecialDiscount(int date) {
        if (isSpecial(date)) {
            String discountName = DiscountInfo.SPECIAL.getName();
            int discountAmount = DiscountInfo.SPECIAL.getAmount();
            return new Discount(discountName, discountAmount);
        }
        return null;
    }

    private Discount getGiftDiscount(GiftMenu gift) {
        if (isGiftDiscount(gift)) {
            String discountName = DiscountInfo.GIFT_EVENT.getName();
            String giftName = gift.getGiftName();
            int discountAmount = Menu.getPriceByName(giftName);
            return new Discount(discountName, discountAmount);
        }
        return null;
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
        return Calender.SUNDAY.isMatch(date)
                || date == 25;
    }

    private boolean isGiftDiscount(GiftMenu gift) {
        return gift.getGiftMenu() != null;
    }
}
