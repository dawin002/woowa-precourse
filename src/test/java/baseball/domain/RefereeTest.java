package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;


class RefereeTest {

    private Referee referee;
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,0볼 3스트라이크", "6,7,8,낫싱", "2,3,1,3볼 0스트라이크"})
    public void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
        assert (actual).equals(expected);
    }
//    아래 테스트들을 위 테스트 하나로 합칠 수 있음
//
//    @Test
//    void 스트라이크3() {
//        String result = referee.compare(ANSWER, Arrays.asList(1, 2, 3));
//        assert (result).equals("0볼 3스트라이크");
//    }
//
//    @Test
//    void 낫싱() {
//        String result = referee.compare(ANSWER, Arrays.asList(6, 7, 8));
//        assert (result).equals("낫싱");
//    }
//
//    @Test
//    void 볼3() {
//        String result = referee.compare(ANSWER, Arrays.asList(2, 3, 1));
//        assert (result).equals("3볼 0스트라이크");
//    }
}