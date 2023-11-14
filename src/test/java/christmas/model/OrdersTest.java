package christmas.model;

import christmas.model.enums.Menu;
import christmas.utils.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrdersTest {
    @DisplayName("주문 관리 생성 및 초기화 테스트")
    @Test
    void ordersInitializeTest() {
        List<String> inputOrder = List.of("타파스-2","제로콜라-3","바비큐립-1");
        Orders orders = new Orders(inputOrder);
        assertThat(orders.getOrderResults().size()).isEqualTo(3);
        assertThat(orders.getOrderResults().keySet()).contains("타파스", "제로콜라", "바비큐립");
        assertThat(orders.getOrderResults().get("타파스")).isEqualTo(2);
        assertThat(orders.getOrderResults().get("제로콜라")).isEqualTo(3);
        assertThat(orders.getOrderResults().get("바비큐립")).isEqualTo(1);
    }

    @DisplayName("중복된 메뉴에 대한 예외 처리 테스트")
    @Test
    void throwsDuplicatedMenuExceptionTest() {
        List<String> inputOrder = List.of("타파스-2","제로콜라-3","타파스-1");
        assertThatThrownBy(() -> new Orders(inputOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료 메뉴로만 이루어진 주문에 대한 예외 처리 테스트")
    @Test
    void throwsOnlyDrinkMenuExceptionTest() {
        List<String> inputOrder = List.of("제로콜라-2","레드와인-3");
        assertThatThrownBy(() -> new Orders(inputOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20개 초과의 총주문 수량에 대한 예외 처리 테스트")
    @Test
    void throwsOverRangeTotalQuantityExceptionTest() {
        List<String> inputOrder = List.of("타파스-20","제로콜라-1");
        assertThatThrownBy(() -> new Orders(inputOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 내역 반환 기능의 반환값 테스트")
    @Test
    void getOrderResultTest() {
        List<String> inputOrder = List.of("타파스-1","제로콜라-2","레드와인-3","바비큐립-4");
        Orders orders = new Orders(inputOrder);
        assertThat(orders.getOrderResults()).isInstanceOf(HashMap.class);
        assertThat(orders.getOrderResults().size()).isEqualTo(4);
        assertThat(orders.getOrderResults().get("타파스")).isEqualTo(1);
        assertThat(orders.getOrderResults().get("제로콜라")).isEqualTo(2);
        assertThat(orders.getOrderResults().get("레드와인")).isEqualTo(3);
        assertThat(orders.getOrderResults().get("바비큐립")).isEqualTo(4);
    }

    @DisplayName("총주문 금액 계산 기능 테스트")
    @MethodSource("listProvider")
    @ParameterizedTest
    void getTotalPriceTest(List<String> inputOrders) {
        int totalPrice = getTotalPrice(inputOrders);
        Orders orders = new Orders(inputOrders);
        assertThat(orders.getTotalPrice()).isEqualTo(totalPrice);
    }

    @DisplayName("타입별 주문 수량 계산 테스트")
    @Test
    void countTypeQuantityTest() {
        List<String> inputOrder = List.of("타파스-1","티본스테이크-2","초코케이크-3","샴페인-4");
        Orders orders = new Orders(inputOrder);
        assertThat(orders.countQuantityOfType("appetizer")).isEqualTo(1);
        assertThat(orders.countQuantityOfType("main")).isEqualTo(2);
        assertThat(orders.countQuantityOfType("dessert")).isEqualTo(3);
        assertThat(orders.countQuantityOfType("drink")).isEqualTo(4);
    }

    static Stream<List<String>> listProvider() {
        return Stream.of(
                Arrays.asList("타파스-1", "제로콜라-2", "아이스크림-3"),
                Arrays.asList("타파스-4", "제로콜라-5", "바비큐립-6"),
                Arrays.asList("레드와인-2", "제로콜라-4", "아이스크림-1")
        );
    }

    static int getTotalPrice(List<String> inputOrders) {
        int totalPrice = 0;
        for (String order : inputOrders) {
            String name = InputParser.getMenu(order);
            int quantity = InputParser.getQuantity(order);
            totalPrice += Menu.getPriceByName(name) * quantity;
        }
        return totalPrice;
    }

}