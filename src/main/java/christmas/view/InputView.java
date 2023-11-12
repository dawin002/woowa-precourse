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
        String[] split = input.split(",");
        List<String> order = List.of(split);
        validateInputOrder(order);
        return order;
    }

    private void validateInputDate(String input) {
        try {
            validator.validateIsBlank(input);
            validator.validateIsNumber(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void validateInputOrder(List<String> orders) {
        try {
            for (String menu : orders) {
                validator.validateIsBlank(menu);
                String[] splitOrder = menu.split("-");
                validateInputMenu(splitOrder[0], splitOrder[1]);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateInputMenu(String name, String number) {
        validator.validateIsBlank(name);
        validator.validateIsBlank(number);
        validator.validateIsNumber(number);
    }

}
