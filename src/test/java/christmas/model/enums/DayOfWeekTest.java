package christmas.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DayOfWeekTest {
    @DisplayName("날짜에 따른 요일 반환 기능 테스트")
    @CsvSource(value = {"1,FRIDAY", "2,SATURDAY", "25,MONDAY", "26,TUESDAY", "31,SUNDAY"})
    @ParameterizedTest
    void returnDayByDateTest(int date, DayOfWeek day) {
        assertThat(DayOfWeek.getDayByDate(date)).isEqualTo(day);
    }

}