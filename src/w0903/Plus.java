package w0903;

import java.util.Scanner;

public class Plus {
    static int plus(int v1, int v2){
        int result = v1 + v2;
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("★프로그램 종료를 원하면 1번째 숫자에 -1을 입력하십시오.: ");
            // Scanner 객체 생성

            System.out.print("★ 첫 번째 정수를 입력하세요: ");
            int num1 = scanner.nextInt();
            if (num1 == -1)
                break;
            System.out.print("★ 두 번째 정수를 입력하세요.: ");
            int num2 = scanner.nextInt();

            int sum = plus(num1, num2);
            System.out.printf("%d + %d = %d\n ", num1, num2, sum);
        }
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
        }
    }

