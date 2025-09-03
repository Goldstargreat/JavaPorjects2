package w0903;

import java.util.Scanner;

public class SimpleCalculator {
    public static int calc(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char op;

        while (true) {
            System.out.print("계산할 연산 기호를 입력해주세요.(+, -, *, /), 종료하려면 e 또는 E를 누르십시오. : ");
            op = scanner.next().charAt(0);

            if (op == 'e' || op == 'E') {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            // 연산자 유효성 검사
            if (op != '+' && op != '-' && op != '*' && op != '/') {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                continue;
            }

            System.out.print("정수1 입력: ");
            int num1 = scanner.nextInt();
            System.out.print("정수2 입력: ");
            int num2 = scanner.nextInt();

            if (op == '/' && num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }

            int result = calc(num1, num2, op);
            System.out.printf("%d %c %d = %d\n", num1, op, num2, result);
        }

        scanner.close();
    }
}