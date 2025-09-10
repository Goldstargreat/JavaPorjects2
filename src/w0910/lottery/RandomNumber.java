package w0910.lottery;

import java.util.Random;

public class RandomNumber {
    public int randomNum(int Max){
        int num = 0;

        Random random = new Random();
        num = random.nextInt(Max) + 1;
        return num;
    }
}
