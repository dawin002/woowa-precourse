package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validations.InputValidator;

import java.util.List;

public class InputView {
    private InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int readDate() {
        String input = Console.readLine();
        inputValidator.validateDate(input);
        return Integer.parseInt(input);
    }

    public List<String> readOrder() {
        String input = Console.readLine();
        List<String> orders = makeInputToList(input);
        for (String order : orders) {
            inputValidator.validateOrder(order);
            inputValidator.validateMenu(getMenuName(order));
            inputValidator.validateQuantity(getMenuQuantity(order));
        }
        return orders;
    }

    private List<String> makeInputToList(String input) {
        String[] splitInput = input.split(",");
        return List.of(splitInput);
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
