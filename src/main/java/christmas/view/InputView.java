package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validations.InputValidator;

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

    private void validateInputDate(String input) {
        try {
            validator.validateIsBlank(input);
            validator.validateIsNumber(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

}
