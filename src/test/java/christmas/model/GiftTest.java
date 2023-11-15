package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GiftTest {
    @DisplayName("증정품 객체 초기화 테스트")
    @CsvSource(value = {"샴페인,1", "아이스크림,2", "제로콜라,3"})
    @ParameterizedTest
    void giftInitializeTest(String giftName, int giftQuantity) {
        Gift gift = new Gift(giftName, giftQuantity);
        assertThat(gift.getName()).isEqualTo(giftName);
        assertThat(gift.getQuantity()).isEqualTo(giftQuantity);
    }

}