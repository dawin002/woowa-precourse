package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView() {
    }

    public int readDate() {
        String input = Console.readLine();
        validateInputDate(input);
        return Integer.parseInt(input);
    }

    private void validateInputDate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
