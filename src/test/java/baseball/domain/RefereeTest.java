package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class RefereeTest {

    private Referee referee;
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    void 스트라이크3() {
        String result = referee.compare(ANSWER, Arrays.asList(1, 2, 3));
        assert (result).equals("0볼 3스트라이크");
    }

    @Test
    void 낫싱() {
        String result = referee.compare(ANSWER, Arrays.asList(6, 7, 8));
        assert (result).equals("낫싱");
    }

    @Test
    void 볼3() {
        String result = referee.compare(ANSWER, Arrays.asList(2, 3, 1));
        assert (result).equals("3볼 0스트라이크");
    }
}