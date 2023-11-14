package christmas.view;

import java.util.HashMap;

public class OutputView {
    public OutputView() {
    }

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
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", visitDate);
    }
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printOrders(HashMap<String, Integer> orderResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<주문 메뉴>\n");
        for (String menu : orderResults.keySet()) {
            int quantity = orderResults.get(menu);
            stringBuilder.append(menu).append(" ").append(quantity).append("개\n");
        }
        System.out.println(stringBuilder);
    }

    public void printTotalPriceBeforeDiscount(int totalPrice) {
        String result = "\n<할인 전 총주문 금액>\n" + String.format("%,d원", totalPrice);
        System.out.println(result);
    }

    public void printGiftMenu(HashMap<String, Integer> giftMenu) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<증정 메뉴>\n");
        for (String menu : giftMenu.keySet()) {
            int quantity = giftMenu.get(menu);
            stringBuilder.append(menu).append(" ").append(quantity).append("개\n");
        }
        if (giftMenu.isEmpty()) {
            stringBuilder.append("없음\n");
        }
        System.out.print(stringBuilder);
    }

    public void printDiscountDetails(HashMap<String, Integer> discountDetails) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<증정 메뉴>\n");
        for (String discountName : discountDetails.keySet()) {
            String amount = String.format("-%,d원\n", discountDetails.get(discountName));
            stringBuilder.append(discountName).append(": ").append(amount);
        }
        if (discountDetails.isEmpty()) {
            stringBuilder.append("없음\n");
        }
        System.out.print(stringBuilder);
    }

    public void printTotalPriceAfterDiscount(int totalPrice) {
        String result = "\n<<총혜택 금액>>\n" + String.format("%,d원", totalPrice);
        System.out.println(result);
    }
}
