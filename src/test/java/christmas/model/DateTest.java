package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @DisplayName("전달된 날짜로 초기화된 Date 객체 생성 테스트")
    @ValueSource(ints = {1, 10, 25, 31})
    @ParameterizedTest
    void dateInitializedByGivenDate(int visitDate) {
        Date date = new Date(visitDate);
        assertThat(date.getDate()).isEqualTo(visitDate);
    }

    @DisplayName("1~31 범위 밖의 날짜에 대한 예외 처리 테스트")
    @ValueSource(ints = {0, 32, -10, 999})
    @ParameterizedTest
    void throwsExceptionByOverRangeDate(int visitDate) {
        assertThatThrownBy(() -> new Date(visitDate))
                .isInstanceOf(IllegalArgumentException.class);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Date(visitDate));
        assertThat(e.getMessage()).contains("유효하지 않은 날짜입니다.", "다시 입력해 주세요.");
    }

}