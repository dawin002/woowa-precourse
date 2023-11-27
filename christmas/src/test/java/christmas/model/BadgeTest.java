package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeTest {
    @DisplayName("총혜택 금액에 따른 배지 이름 초기화 테스트")
    @CsvSource(value = {"0,없음", "4999,없음", "5000,별", "9999,별", "10000,트리", "19999,트리", "20000,산타", "100000,산타"})
    @ParameterizedTest
    void initializeBadgeByDiscountAmount(int discountAmount, String badgeName) {
        Badge badge = new Badge(discountAmount);
        assertThat(badge.getName()).isEqualTo(badgeName);
    }

}