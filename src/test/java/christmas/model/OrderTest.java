package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @DisplayName("주문 객체 생성 및 초기화")
    @CsvSource(value = {"초코케이크,3", "티본스테이크,1", "양송이수프,2"})
    @ParameterizedTest
    void orderInitializeTest(String name, int quantity) {
        Order order = new Order(name, quantity);
        assertThat(order.getName()).isEqualTo(name);
        assertThat(order.getQuantity()).isEqualTo(quantity);
    }

    @DisplayName("존재하지 않는 메뉴에 대한 예외 처리")
    @CsvSource(value = {"초코 케이크,2", "스테이크티본,4", "사이다,6"})
    @ParameterizedTest
    void noMatchingMenuExceptionTest(String name, int quantity) {
        assertThatThrownBy(() -> new Order(name, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1보다 작은 주문 수량에 대한 예외 처리")
    @CsvSource(value = {"티본스테이크,-1", "초코케이크,0", "아이스크림,-10"})
    @ParameterizedTest
    void underRangeQuantityExceptionTest(String name, int quantity) {
        assertThatThrownBy(() -> new Order(name, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

}