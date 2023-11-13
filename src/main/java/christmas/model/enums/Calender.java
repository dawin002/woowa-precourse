package christmas.model.enums;

import java.util.List;

public enum Calender {
    SUNDAY(List.of(3, 10, 17, 24, 31)),
    MONDAY(List.of(4, 11, 18, 25)),
    TUESDAY(List.of(5, 12, 19, 26)),
    WEDNESDAY(List.of(6, 13, 20, 27)),
    THURSDAY(List.of(7, 14, 21, 28)),
    FRIDAY(List.of(1, 8, 15, 22, 29)),
    SATURDAY(List.of(2, 9, 16, 23, 30));

    private final List<Integer> dates;

    Calender(List<Integer> dates) {
        this.dates = dates;
    }

    public boolean isMatch(int date) {
        return this.dates.contains(date);
    }
}
