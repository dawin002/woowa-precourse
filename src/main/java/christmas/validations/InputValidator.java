package christmas.validations;

public class InputValidator {
    public static void validateDate(String date) {
        if (date.isBlank()
                || isNotNumber(date)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateOrder(String order) {
        if (order.isBlank()
                || !order.contains("-")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateMenu(String menu) {
        if (menu.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateQuantity(String quantity) {
        if (quantity.isBlank()
                || isNotNumber(quantity)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isNotNumber(String input) {
        for (char number : input.toCharArray()) {
            if ((int) number < (int) '0' || (int) number > (int) '9') {
                return true;
            }
        }
        return false;
    }
}
