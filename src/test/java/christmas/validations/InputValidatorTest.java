package christmas.validations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("빈 날짜 입력 문자열에 대한 예외 처리")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void validateDateHasBlank(String inputDate) {
        assertThatThrownBy(() -> InputValidator.validateDate(inputDate))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수로 변환할 수 없는 날짜 입력에 대한 예외 처리")
    @ValueSource(strings = {"a", "1.2", "23일", " 1", "1 2", "2 "})
    @ParameterizedTest
    void validateDateCantParseInt(String inputDate) {
        assertThatThrownBy(() -> InputValidator.validateDate(inputDate))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 주문 입력 문자열에 대한 예외 처리")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void validateOrderHasBlank(String inputOrder) {
        assertThatThrownBy(() -> InputValidator.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("하이픈이 없는 주문 입력에 대한 예외 처리")
    @ValueSource(strings = {"아이스크림", "아이스크림_1", "아이스크림1", "아이스크림:1"})
    @ParameterizedTest
    void validateOrderNoHyphen(String inputOrder) {
        assertThatThrownBy(() -> InputValidator.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 메뉴 이름 문자열에 대한 예외 처리")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void validateMenuHasBlank(String inputMenu) {
        assertThatThrownBy(() -> InputValidator.validateMenu(inputMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 메뉴 수량 문자열에 대한 예외 처리")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void validateQuantityHasBlank(String inputQuantity) {
        assertThatThrownBy(() -> InputValidator.validateQuantity(inputQuantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수로 변환할 수 없는 메뉴 수량에 대한 예외 처리")
    @ValueSource(strings = {"0.1", "1.0", "1a", "1개", " 1", "1 ", "1 0"})
    @ParameterizedTest
    void validateQuantityCantParseInt(String inputQuantity) {
        assertThatThrownBy(() -> InputValidator.validateQuantity(inputQuantity))
                .isInstanceOf(IllegalArgumentException.class);
    }
}