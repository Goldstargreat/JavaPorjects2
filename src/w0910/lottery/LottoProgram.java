package w0910.lottery;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoProgram {
    public static void main(String[] args) {
        System.out.println("============= 로또 프로그램 ============");
        ArrayList<Integer> numList = new ArrayList();

        int randNum = 0;
        RandomNumber rn = new RandomNumber();

        reFindNum:
        while (true) {
            randNum = rn.randomNum(45);
            for(int num : numList){
                if(num == randNum)
                    continue reFindNum;

            }
            numList.add(randNum);

            if(numList.size() == 6)
                break;
        }

        Object[] numAry = numList.toArray();
        Arrays.sort(numAry);
        System.out.println("========= 이번 주 로또의 당첨 번호 ==============");
        System.out.println(Arrays.toString(numAry));
    }
}
