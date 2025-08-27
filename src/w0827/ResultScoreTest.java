package w0827;

import java.util.Arrays;
import java.util.Scanner;

public class ResultScoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] score = new int[5];
        int sum = 0;
        double avg = 0;

        System.out.println("김연아 선수의 경기가 끝났습니다!");
        System.out.println("심사 위원들은 점수를 매겨주십시오!");

        for(int i = 0; i < score.length; i++){
            System.out.print("심사위원 " + (i + 1) + "입력: ");
            score[i] = scanner.nextInt();
            sum += score[i];
        }
        avg = sum/score.length;

        System.out.println("심사위원 개별 점수: " + Arrays.toString(score));
        System.out.printf("심사위원 평균 점수: %.1f\n", avg);
        scanner.close();
    }
}
