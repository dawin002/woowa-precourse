package christmas.validations;

public class InputValidator {

    public boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public boolean isBlank(String input) {
        return input.isBlank();
    }

    public boolean isNotNumber(String input) {
        for (char number : input.toCharArray()) {
            if ((int) number < (int) '0' || (int) number > (int) '9') {
                return true;
            }
        }
        return false;
    }
}
