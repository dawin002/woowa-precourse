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
            stringBuilder.append(menu).append(" ").append(orderResults.get(menu)).append("개\n");
        }
        System.out.println(stringBuilder);
    }
}
