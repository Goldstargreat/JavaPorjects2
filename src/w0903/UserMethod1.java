package w0903;

import java.util.Random;

public class UserMethod1 {
    public static void outputDice(String username) {
        System.out.println(username + "이(가) 주사위를 던집니다.");
        Random random = new Random();
        int diceNum = random.nextInt(6) + 1;
        System.out.println("주사위를 던진 결과: " + diceNum);
    }

    public static void main(String[] args) {
        outputDice("장원영");
        outputDice("트럼프");
        outputDice("이시바");
    }
}
