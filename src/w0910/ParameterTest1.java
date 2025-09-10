package w0910;

import java.util.Scanner;

public class ParameterTest1 {
    public static void main(String[] args) {
        System.out.println("=== 2개의 정수의 합을 구한다.===");
        Scanner scanner = new Scanner(System.in);

        System.out.println("첫번째 정수를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.println("두 번째 정수를 입력하세요: ");
        int num2 = scanner.nextInt();

        Calc1 calc1 = new Calc1();
        int result = calc1.plus(num1, num2);
        System.out.println("덧셈 결과 = " + result);
    }
}
