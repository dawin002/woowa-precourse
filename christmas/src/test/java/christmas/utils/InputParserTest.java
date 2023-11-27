package christmas.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @DisplayName("주문 문자열에서 메뉴 이름 파싱 테스트")
    @Test
    void getMenuFromInputOrderTest() {
        String inputOrder = "제로콜라-1";
        assertThat(InputParser.getMenu(inputOrder)).isEqualTo("제로콜라");
    }

    @DisplayName("주문 문자열에서 메뉴 수량 파싱 테스트")
    @Test
    void getQuantityFromInputOrderTest() {
        String inputOrder = "제로콜라-1";
        assertThat(InputParser.getQuantity(inputOrder)).isEqualTo(1);
    }
}