package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountServiceTest {

    private DiscountService service;

    @BeforeEach
    void setUp() {
        service = new DiscountService();
    }

    @DisplayName("총주문 금액이 1만원 이상인 경우 혜택 적용")
    @Test
    void checkApplicableUpperTotalPrice() {
        Date date = new Date(25);
        Orders orders = new Orders(List.of("아이스크림-2"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        assertThat(details.getTotalDiscountAmount()).isNotEqualTo(0);
        assertThat(details.getDetails().isEmpty()).isEqualTo(false);
    }

    @DisplayName("총주문 금액이 1만원 미만인 경우 혜택 미적용")
    @Test
    void checkApplicableUnderTotalPrice() {
        Date date = new Date(25);
        Orders orders = new Orders(List.of("아이스크림-1"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        assertThat(details.getTotalDiscountAmount()).isEqualTo(0);
        assertThat(details.getDetails().isEmpty()).isEqualTo(true);
    }

    @DisplayName("1~25일 사이인 경우 크리스마스 디데이 할인 적용")
    @CsvSource(value = {"1,1000", "2,1100", "24,3300", "25,3400"})
    @ParameterizedTest
    void christmasDiscountAppliedTest(int visitDate, int discountAmount) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-2", "바비큐립-2", "제로콜라-2", "아이스크림-2"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            if (discount.getName().equals("크리스마스 디데이 할인")) {
                assertThat(discount.getAmount()).isEqualTo(discountAmount);
            }
        }
    }

    @DisplayName("1~25일이 아닌 경우 크리스마스 디데이 할인 미적용")
    @CsvSource(value = {"26", "27", "30", "31"})
    @ParameterizedTest
    void christmasDiscountNotAppliedTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-2", "바비큐립-2", "제로콜라-2", "아이스크림-2"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            assertThat(discount.getName()).isNotEqualTo("크리스마스 디데이 할인");
        }
    }

    @DisplayName("날짜가 평일인 경우 평일 할인 적용")
    @CsvSource(value = {"11", "19", "26", "27"})
    @ParameterizedTest
    void weekDayDiscountAppliedTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "바비큐립-1", "제로콜라-1", "아이스크림-2"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            if (discount.getName().equals("평일 할인")) {
                assertThat(discount.getAmount()).isEqualTo(4046);
            }
        }
    }

    @DisplayName("날짜가 평일이 아닌 경우 평일 할인 미적용")
    @CsvSource(value = {"1", "9", "16", "23"})
    @ParameterizedTest
    void weekDayDiscountNotAppliedTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "바비큐립-1", "제로콜라-1", "아이스크림-2"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            assertThat(discount.getName()).isNotEqualTo("평일 할인");
        }
    }

    @DisplayName("날짜가 평일이지만 디저트 주문이 없는 경우 평일 할인 미적용")
    @CsvSource(value = {"11", "19", "26", "27"})
    @ParameterizedTest
    void weekDayDiscountNotAppliedByNoDessertTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "바비큐립-1", "제로콜라-1"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            assertThat(discount.getName()).isNotEqualTo("평일 할인");
        }
    }

    @DisplayName("날짜가 주말인 경우 주말 할인 적용")
    @CsvSource(value = {"1", "9", "16", "23"})
    @ParameterizedTest
    void weekEndDiscountAppliedTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "바비큐립-3", "제로콜라-1", "아이스크림-1"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            if (discount.getName().equals("주말 할인")) {
                assertThat(discount.getAmount()).isEqualTo(6069);
            }
        }
    }

    @DisplayName("날짜가 주말이 아닌 경우 주말 할인 미적용")
    @CsvSource(value = {"11", "19", "26", "27"})
    @ParameterizedTest
    void weekEndDiscountNotAppliedTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "바비큐립-3", "제로콜라-1", "아이스크림-1"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            assertThat(discount.getName()).isNotEqualTo("주말 할인");
        }
    }

    @DisplayName("날짜가 주말인 경우 주말 할인 적용")
    @CsvSource(value = {"1", "9", "16", "23"})
    @ParameterizedTest
    void weekEndDiscountNotAppliedByNoMainTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "제로콜라-1", "아이스크림-1"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            assertThat(discount.getName()).isNotEqualTo("주말 할인");
        }
    }

    @DisplayName("일요일 또는 25일인 경우 특별 할인 적용")
    @CsvSource(value = {"3", "10", "24", "25"})
    @ParameterizedTest
    void specialDiscountAppliedTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "바비큐립-3", "제로콜라-1", "아이스크림-1"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            if (discount.getName().equals("특별 할인")) {
                assertThat(discount.getAmount()).isEqualTo(1000);
            }
        }
    }

    @DisplayName("일요일 또는 25일이 아닌 경우 특별 할인 미적용")
    @CsvSource(value = {"2", "9", "23", "26"})
    @ParameterizedTest
    void specialDiscountNotAppliedTest(int visitDate) {
        Date date = new Date(visitDate);
        Orders orders = new Orders(List.of("타파스-1", "바비큐립-3", "제로콜라-1", "아이스크림-1"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            assertThat(discount.getName()).isNotEqualTo("특별 할인");
        }
    }

    @DisplayName("총주문 금액이 120000원 이상인 경우 증정 이벤트 적용")
    @Test
    void giftDiscountAppliedTest() {
        Date date = new Date(1);
        Orders orders = new Orders(List.of("바비큐립-3"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            if (discount.getName().equals("증정 이벤트")) {
                assertThat(discount.getAmount()).isEqualTo(25000);
            }
        }
    }

    @DisplayName("총주문 금액이 120000원 미만인 경우 증정 이벤트 미적용")
    @Test
    void giftDiscountNotAppliedTest() {
        Date date = new Date(1);
        Orders orders = new Orders(List.of("바비큐립-2"));
        Gifts gifts = new Gifts(orders.getTotalPrice());

        DiscountDetails details = service.calculateDiscounts(date, orders, gifts);

        for (Discount discount : details.getDetails()) {
            assertThat(discount.getName()).isNotEqualTo("증정 이벤트");
        }
    }

}