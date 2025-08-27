package w0827;

import java.util.Arrays;

public class CloneArrayTest {
    public static void main(String[] args) {
        // NOT CLONE
        String[] originArr1 = {"김치찌개", "잔치국수", "감자탕", "돈가스"};
        String[] originArr2 = originArr1;

        originArr1[1] = "라구파스타";
        originArr2[2] = "탕수육";

        System.out.println(Arrays.toString(originArr1));
        System.out.println(Arrays.toString(originArr2));

        // IN CASE OF CLONE
        String[] originArr = {"다니엘", "민지", "해인", "해린"};
        String[] cloneArr = originArr.clone();

        cloneArr[0] = "장원영";
        cloneArr[2] = "이서";

        System.out.println(Arrays.toString(originArr));
        System.out.println(Arrays.toString(cloneArr));
    }
}
