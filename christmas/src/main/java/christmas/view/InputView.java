package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validations.InputValidator;

import java.util.List;

public class InputView {
    private final static String INPUT_SEPARATOR = ",";
    private final static String ORDER_SEPARATOR = "-";
    private final static int MENU_NAME_INDEX = 0;
    private final static int MENU_QUANTITY_INDEX = 1;

    public int readDate() {
        String input = Console.readLine();
        InputValidator.validateDate(input);
        return Integer.parseInt(input);
    }

    public List<String> readOrder() {
        String input = Console.readLine();
        List<String> orders = makeInputToList(input);
        for (String order : orders) {
            InputValidator.validateOrder(order);
            InputValidator.validateMenu(getMenuName(order));
            InputValidator.validateQuantity(getMenuQuantity(order));
        }
        return orders;
    }

    private List<String> makeInputToList(String input) {
        String[] splitInput = input.split(INPUT_SEPARATOR);
        return List.of(splitInput);
    }

    private String getMenuName(String order) {
        String[] splitOrder = order.split(ORDER_SEPARATOR);
        return splitOrder[MENU_NAME_INDEX];
    }

    private String getMenuQuantity(String order) {
        String[] splitOrder = order.split(ORDER_SEPARATOR);
        return splitOrder[MENU_QUANTITY_INDEX];
    }
}
