package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiscountDetailsTest {

    private DiscountDetails discountDetails;
    @BeforeEach
    void setUp() {
        discountDetails = new DiscountDetails();
        discountDetails.addDiscount(new Discount("크리스마스 디데이 할인", 3400));
        discountDetails.addDiscount(new Discount("주말 할인", 4046));
        discountDetails.addDiscount(new Discount("증정 이벤트", 25000));
    }

    @DisplayName("혜택 내역 추가 기능 테스트")
    @CsvSource(value = {"평일 할인,2023", "주말 할인,4046", "크리스마스 디데이 할인,3400"})
    @ParameterizedTest
    void addDiscountTest(String discountName, int discountAmount) {
        DiscountDetails detailsForAddTest = new DiscountDetails();

        detailsForAddTest.addDiscount(new Discount(discountName, discountAmount));

        for (Discount discount : detailsForAddTest.getDetails()) {
            assertThat(discount.getName()).isEqualTo(discountName);
            assertThat(discount.getAmount()).isEqualTo(discountAmount);
        }
    }

    @DisplayName("혜택 내역 반환 기능 테스트")
    @Test
    void getDetailsTest() {
        assertThat(discountDetails.getDetails().size()).isEqualTo(3);
        for (Discount discount : discountDetails.getDetails()) {
            if (discount.getName().equals("크리스마스 디데이 할인")) {
                assertThat(discount.getAmount()).isEqualTo(3400);
            }
            if (discount.getName().equals("주말 할인")) {
                assertThat(discount.getAmount()).isEqualTo(4046);
            }
            if (discount.getName().equals("증정 이벤트")) {
                assertThat(discount.getAmount()).isEqualTo(25000);
            }
        }
    }

    @DisplayName("총할인 금액 계산 기능 테스트")
    @Test
    void getTotalDiscountAmountTest() {
        int expectedTotalAmount = 3400 + 4046 + 25000;
        assertThat(discountDetails.getTotalDiscountAmount()).isEqualTo(expectedTotalAmount);
    }

    @DisplayName("증정 이벤트를 제외한 총할인 금액 계산 기능 테스트")
    @Test
    void getTotalDiscountAmountWithoutGiftTest() {
        int expectedTotalAmount = 3400 + 4046;
        assertThat(discountDetails.getTotalDiscountAmountWithoutGift()).isEqualTo(expectedTotalAmount);
    }
}