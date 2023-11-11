package christmas.validations;

import java.util.List;

public class InputValidator {

    public void validateIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateIsNumber(String input) {
        for (char number : input.toCharArray()) {
            if ((int) number < (int) '0' || (int) number > (int) '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}
