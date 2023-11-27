package christmas.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @DisplayName("존재하지 않는 메뉴인지 반환하는 기능 테스트")
    @ValueSource(strings = {"사이다", "제로콜라 ", " 제로콜라", "제로 콜라"})
    @ParameterizedTest
    void notExistMenuTest(String menuName) {
        assertThat(Menu.isNotExistMenu(menuName)).isEqualTo(true);
    }

    @DisplayName("메뉴 이름으로 타입을 반환하는 기능 테스트")
    @CsvSource(value = {"양송이수프,appetizer", "티본스테이크,main", "초코케이크,dessert", "제로콜라,drink"})
    @ParameterizedTest
    void getTypeByMenuNameTest(String menuName, String type) {
        assertThat(Menu.getTypeByName(menuName)).isEqualTo(type);
    }

    @DisplayName("메뉴 이름으로 가격을 반환하는 기능 테스트")
    @CsvSource(value = {"양송이수프,6000", "티본스테이크,55000", "초코케이크,15000", "제로콜라,3000"})
    @ParameterizedTest
    void getPriceByMenuNameTest(String menuName, int price) {
        assertThat(Menu.getPriceByName(menuName)).isEqualTo(price);
    }

}