package christmas.model;

public class Date {
    private int date;

    public Date(int date) {
        validateDate(date);
        this.date = date;
    }

    private void validateDate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
