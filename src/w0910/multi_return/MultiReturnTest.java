package w0910.multi_return;

import w0910.Calc1;

public class MultiReturnTest {
    public static void main(String[] args) {
        MultiInput input = new MultiInput();
        int[] scores = input.inputScores();
        Calc1 calc = new Calc1();
        calc.plus(scores);
        int result = calc.plus(scores);

        System.out.print(scores.length + "개 정수의 합계: " + result);
    }
}
