package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    void setRound_전달받은_문자열을_숫자로_변환해_이동_회수로_저장() {
        //given
        String roundInput = "3";
        Round round = new Round();

        //when
        round.setRound(roundInput);

        //then
        assertThat(round.getRound()).isEqualTo(3);
    }

    @Test
    void isRemaining_남은_이동_회수가_0보다_큰_경우_true_반환() {
        //given
        String roundInput = "3";
        Round round = new Round();
        round.setRound(roundInput);

        //when
        boolean isRemain = round.isRemaining();

        //then
        assertThat(isRemain).isEqualTo(true);
    }

    @Test
    void isRemaining_남은_이동_회수가_0보다_작거나_같은_경우_false_반환() {
        ///given
        String roundInput = "0";
        Round round = new Round();
        round.setRound(roundInput);

        //when
        boolean isRemain = round.isRemaining();

        //then
        assertThat(isRemain).isEqualTo(false);
    }

    @Test
    void subtractOne() {
        //given

        //when

        //then
    }
}