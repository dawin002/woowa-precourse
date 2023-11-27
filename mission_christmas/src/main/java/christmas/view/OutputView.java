package christmas.view;

import christmas.dto.DiscountResult;
import christmas.dto.GiftResult;
import christmas.dto.OrderResult;
import christmas.model.Discount;
import christmas.model.Gift;
import christmas.model.Order;

public class OutputView {
    private final static String START_PLANNER_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String READ_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final static String READ_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String START_RESULT_FORMAT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String NONE = "없음\n";
    private static final String PRICE_FORMAT = "%,d";
    private static final String COUNT_QUANTITY = "개\n";
    private static final String COUNT_PRICE = "원\n";
    private static final String SPACE = " ";
    private static final String COLON = ":";

    public void printStartMessage() {
        System.out.println(START_PLANNER_MESSAGE);
    }

    public void printReadDate() {
        System.out.println(READ_DATE_MESSAGE);
    }

    public void printReadOrder() {
        System.out.println(READ_ORDER_MESSAGE);
    }

    public void printStartResult(int visitDate) {
        System.out.println(String.format(START_RESULT_FORMAT, visitDate));
    }

    public void printOrders(OrderResult orderResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Message.ORDER_TITLE.getTitle());
        for (Order order : orderResults.getOrders()) {
            stringBuilder.append(order.getName())
                    .append(SPACE)
                    .append(order.getQuantity())
                    .append(COUNT_QUANTITY);
        }
        System.out.print(stringBuilder);
    }

    public void printTotalPriceBeforeDiscount(int totalPrice) {
        String result = Message.PRICE_BEFORE_DISCOUNT_TITLE.getTitle()
                + String.format(PRICE_FORMAT, totalPrice)
                + COUNT_PRICE;
        System.out.print(result);
    }

    public void printGiftMenu(GiftResult giftResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Message.GIFT_TITLE.getTitle());
        for (Gift gift : giftResult.getGifts()) {
            stringBuilder.append(gift.getName())
                    .append(SPACE)
                    .append(gift.getQuantity())
                    .append(COUNT_QUANTITY);
        }
        if (giftResult.getGifts().isEmpty()) {
            stringBuilder.append(NONE);
        }
        System.out.print(stringBuilder);
    }

    public void printDiscountDetails(DiscountResult discountResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Message.DISCOUNT_DETAILS_TITLE.getTitle());
        for (Discount discount : discountResult.getDiscounts()) {
            stringBuilder.append(discount.getName())
                    .append(COLON)
                    .append(SPACE)
                    .append(String.format(PRICE_FORMAT, -discount.getAmount()))
                    .append(COUNT_PRICE);
        }
        if (discountResult.getDiscounts().isEmpty()) {
            stringBuilder.append(NONE);
        }
        System.out.print(stringBuilder);
    }

    public void printTotalDiscountAmount(int totalAmount) {
        String result = Message.TOTAL_DISCOUNT_TITLE.getTitle()
                + String.format(PRICE_FORMAT, -totalAmount)
                + COUNT_PRICE;
        System.out.print(result);
    }

    public void printTotalPriceAfterDiscount(int totalPrice) {
        String result = Message.PRICE_AFTER_DISCOUNT_TITLE.getTitle()
                + String.format(PRICE_FORMAT, totalPrice)
                + COUNT_PRICE;
        System.out.print(result);
    }

    public void printEventBadge(String name) {
        System.out.println(Message.BADGE_TITLE.getTitle() + name);
    }

    public void printError(String errorMessage) {
        String errorResult = ERROR_HEADER + errorMessage;
        System.out.println(errorResult);
    }

    public enum Message {
        TITLE_HEADER_START("\n<"),
        TITLE_HEADER_END(">\n"),
        ORDER_TITLE("주문 메뉴"),
        PRICE_BEFORE_DISCOUNT_TITLE("할인 전 총주문 금액"),
        GIFT_TITLE("증정 메뉴"),
        DISCOUNT_DETAILS_TITLE("혜택 내역"),
        TOTAL_DISCOUNT_TITLE("총혜택 금액"),
        PRICE_AFTER_DISCOUNT_TITLE("할인 후 예상 결제 금액"),
        BADGE_TITLE("12월 이벤트 배지");
        private final String text;

        Message(String text) {
            this.text = text;
        }

        public String getTitle() {
            return TITLE_HEADER_START.text + this.text + TITLE_HEADER_END.text;
        }

    }
}
