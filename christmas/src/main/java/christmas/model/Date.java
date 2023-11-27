package christmas.model;

public class Date {
    private final static int DATE_RANGE_START = 1;
    private final static int DATE_RANGE_END = 31;
    private final static String ERROR_OUT_RANGE_DATE = "Input date is out of range.";
    private final int date;

    public Date(int date) {
        validateDate(date);
        this.date = date;
    }

    private void validateDate(int date) {
        if (date < DATE_RANGE_START || date > DATE_RANGE_END) {
            throw new IllegalArgumentException(ERROR_OUT_RANGE_DATE);
        }
    }

    public int getDate() {
        return this.date;
    }
}
