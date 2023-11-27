package christmas.validations;

public class InputValidator {
    private final static String ERROR_DATE_IS_BLANK = "날짜 입력값이 비어 있습니다.";
    private final static String ERROR_DATE_CAN_NOT_PARSE_INT = "날짜 입력값을 숫자로 바꿀 수 없습니다.";
    private final static String ERROR_ORDER_IS_BLANK = "주문 입력값이 비어 있습니다.";
    private final static String ERROR_ORDER_NOT_CONTAINS_SEPARATOR = "주문 입력값에 구분자가 포함되지 않았습니다.";
    private final static String ERROR_MENU_NAME_iS_BLANK = "메뉴 이름 입력값이 비어 있습니다.";
    private final static String ERROR_MENU_QUANTITY_IS_BLANK = "메뉴 수량 입력값이 비어 있습니다.";
    private final static String ERROR_MENU_QUANTITY_CAN_NOT_PARSE_INT = "메뉴 수량 입력값을 숫자로 바꿀 수 없습니다.";
    private final static char CHAR_0 = '0';
    private final static char CHAR_9 = '9';
    private final static String SEPARATOR = "-";
    public static void validateDate(String date) {
        if (date.isBlank()) {
            throw new IllegalArgumentException(ERROR_DATE_IS_BLANK);
        }
        if (isNotNumber(date)) {
            throw new IllegalArgumentException(ERROR_DATE_CAN_NOT_PARSE_INT);
        }
    }

    public static void validateOrder(String order) {
        if (order.isBlank()) {
            throw new IllegalArgumentException(ERROR_ORDER_IS_BLANK);
        }
        if (!order.contains(SEPARATOR)) {
            throw new IllegalArgumentException(ERROR_ORDER_NOT_CONTAINS_SEPARATOR);
        }
    }

    public static void validateMenu(String menu) {
        if (menu.isBlank()) {
            throw new IllegalArgumentException(ERROR_MENU_NAME_iS_BLANK);
        }
    }

    public static void validateQuantity(String quantity) {
        if (quantity.isBlank()) {
            throw new IllegalArgumentException(ERROR_MENU_QUANTITY_IS_BLANK);
        }
        if (isNotNumber(quantity)) {
            throw new IllegalArgumentException(ERROR_MENU_QUANTITY_CAN_NOT_PARSE_INT);
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
