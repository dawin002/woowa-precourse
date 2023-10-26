package baseball;

import baseball.domain.Judgement;
import baseball.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * 객체 지향 프로그래밍
 * 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다.
 * 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다.(의인화)
 * 3. 각 결과를 종합한다.
 *
 * 인텔리제이 코드 자동 맞추기 단축키
 * command + option + L
 */
public class Application {
    public static void main(String[] args) {
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> numbers = generator.createRandomNumbers();
//        System.out.println(numbers);

        Judgement judgement = new Judgement();
        int result = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(4, 9, 6));
        System.out.println(result);

        boolean place = judgement.hasPlace(Arrays.asList(7, 8, 9), 1, 8);
        System.out.println(place);
    }
}
