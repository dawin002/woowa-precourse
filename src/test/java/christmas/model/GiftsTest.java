package christmas.model;

import christmas.model.enums.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GiftsTest {
    @DisplayName("총주문 금액에 따른 증정품 증정 테스트")
    @ValueSource(ints = {120000, 130000, 200000})
    @ParameterizedTest
    void setGiftOverPriceTest(int totalPrice) {
        Gifts gifts = new Gifts(totalPrice);
        assertThat(gifts.getGifts().size()).isEqualTo(1);
        for (Gift gift : gifts.getGifts()) {
            assertThat(gift.getName()).isEqualTo(Menu.CHAMPAGNE.getName());
            assertThat(gift.getQuantity()).isEqualTo(1);
        }
    }

    @DisplayName("총주문 금액에 따른 증정품 미증정 테스트")
    @ValueSource(ints = {5000, 50000, 119999})
    @ParameterizedTest
    void doNotSetGiftUnderPriceTest(int totalPrice) {
        Gifts gifts = new Gifts(totalPrice);
        assertThat(gifts.getGifts().isEmpty()).isEqualTo(true);
    }

    @DisplayName("증정품 반환 기능 반환값 테스트")
    @Test
    void getGiftMenuTest() {
        int totalPrice = 120000;
        Gifts gifts = new Gifts(totalPrice);
        assertThat(gifts.getGifts()).isInstanceOf(List.class);
        List<Gift> giftList = gifts.getGifts();
        assertThat(giftList.size()).isEqualTo(1);
        for (Gift gift : giftList) {
            assertThat(gift.getName()).isEqualTo("샴페인");
            assertThat(gift.getQuantity()).isEqualTo(1);
        }
    }

}