package christmas.view;

import christmas.dto.DiscountResult;
import christmas.dto.GiftResult;
import christmas.dto.OrderResult;
import christmas.model.Discount;
import christmas.model.Gift;
import christmas.model.Order;

public class OutputView {
    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printReadDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void printReadOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printStartResult(int visitDate) {
        String result = "12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
        System.out.println(result);
    }

    public void printOrders(OrderResult orderResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<주문 메뉴>\n");
        for (Order order : orderResults.getOrders()) {
            stringBuilder.append(order.getName())
                    .append(" ")
                    .append(order.getQuantity())
                    .append("개\n");
        }
        System.out.print(stringBuilder);
    }

    public void printTotalPriceBeforeDiscount(int totalPrice) {
        String result = "\n<할인 전 총주문 금액>\n" + String.format("%,d원", totalPrice);
        System.out.println(result);
    }

    public void printGiftMenu(GiftResult giftResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<증정 메뉴>\n");
        for (Gift gift : giftResult.getGifts()) {
            stringBuilder.append(gift.getName())
                    .append(" ")
                    .append(gift.getQuantity())
                    .append("개\n");
        }
        if (giftResult.getGifts().isEmpty()) {
            stringBuilder.append("없음\n");
        }
        System.out.print(stringBuilder);
    }

    public void printDiscountDetails(DiscountResult discountResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<혜택 내역>\n");
        for (Discount discount : discountResult.getDiscounts()) {
            stringBuilder.append(discount.getName())
                    .append(": ")
                    .append(String.format("-%,d", discount.getAmount()))
                    .append("원\n");
        }
        if (discountResult.getDiscounts().isEmpty()) {
            stringBuilder.append("없음\n");
        }
        System.out.print(stringBuilder);
    }

    public void printTotalDiscountAmount(int totalAmount) {
        totalAmount = -totalAmount;
        String result = "\n<총혜택 금액>\n" + String.format("%,d원", totalAmount);
        System.out.println(result);
    }

    public void printTotalPriceAfterDiscount(int totalPrice) {
        String result = "\n<할인 후 예상 결제 금액>\n" + String.format("%,d원", totalPrice);
        System.out.println(result);
    }

    public void printEventBadge(String name) {
        String result = "\n<12월 이벤트 배지>\n" + name;
        System.out.println(result);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
