package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GiftMenuTest {
    @DisplayName("총주문 금액에 따른 증정품 증정 테스트")
    @ValueSource(ints = {120000, 130000, 200000})
    @ParameterizedTest
    void setGiftOverPriceTest(int totalPrice) {
        GiftMenu gift = new GiftMenu(totalPrice);
        assertThat(gift.getGiftName()).isEqualTo("샴페인");
    }

    @DisplayName("총주문 금액에 따른 증정품 미증정 테스트")
    @ValueSource(ints = {5000, 50000, 119999})
    @ParameterizedTest
    void doNotSetGiftUnderPriceTest(int totalPrice) {
        GiftMenu gift = new GiftMenu(totalPrice);
        assertThat(gift.getGiftName()).isEqualTo(null);
    }

    @DisplayName("증정품 반환 기능 반환값 테스트")
    @Test
    void getGiftMenuTest() {
        int totalPrice = 120000;
        GiftMenu gift = new GiftMenu(totalPrice);
        assertThat(gift.getGiftMenu()).isInstanceOf(HashMap.class);
        HashMap<String, Integer> giftMenu = gift.getGiftMenu();
        assertThat(giftMenu.size()).isEqualTo(1);
        for (String menuName : giftMenu.keySet()) {
            assertThat(menuName).isEqualTo("샴페인");
            assertThat(giftMenu.get(menuName)).isEqualTo(1);
        }
    }

}