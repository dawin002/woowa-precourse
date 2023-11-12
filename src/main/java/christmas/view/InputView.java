package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validations.InputValidator;

import java.util.List;

public class InputView {
    private InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
    }

    public int readDate() {
        String input = Console.readLine();
        validateInputDate(input);
        return Integer.parseInt(input);
    }

    public List<String> readOrder() {
        String input = Console.readLine();
        List<String> orders = makeInputToList(input);
        for (String order : orders) {
            validateInputOrder(order);
        }
        return orders;
    }

    private List<String> makeInputToList(String input) {
        String[] splitInput = input.split(",");
        return List.of(splitInput);
    }

    private void validateInputDate(String input) {
        if (validator.isBlank(input)
                || validator.isNotNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void validateInputOrder(String order) {
        if (validator.isBlank(order)
                || validator.isNotContains(order, "-")
                || validator.isBlank(getMenuName(order))
                || validator.isBlank(getMenuQuantity(order))
                || validator.isNotNumber(getMenuQuantity(order))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private String getMenuName(String order) {
        String[] splitOrder = order.split("-");
        return splitOrder[0];
    }

    private String getMenuQuantity(String order) {
        String[] splitOrder = order.split("-");
        return splitOrder[1];
    }
}
