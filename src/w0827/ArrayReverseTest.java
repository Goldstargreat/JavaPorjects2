package w0827;

import java.util.Arrays;
import java.util.Collections;

public class ArrayReverseTest {
    public static void main(String[] args) {
        String[] memberArr = {"소원", "유주", "예린", "신비", "은하", "엄지"};
        System.out.println("처음 배열: " + Arrays.toString(memberArr));

        Collections.reverse(Arrays.asList(memberArr));
        System.out.print("역순 배열: " + Arrays.toString(memberArr));
    }
}
