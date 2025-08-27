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

        for (int i = 0; i < score.length; i++) {
            System.out.print("심사위원 " + (i + 1) + "입력: ");
            int input = scanner.nextInt();

            // 점수 유효성 검사
            if (score[i] > 10) {
                System.out.println("오류: 10점 이하의 점수만 입력할 수 있습니다. 다시 입력해주세요.");
                i--; // 현재 순서를 다시 실행하기 위해 인덱스를 1 감소시킴
                continue; // 다음 루프 실행
            }
                score[i] = input;
                sum += score[i];
            }
            avg = (double) sum / score.length;

            System.out.println("심사위원 개별 점수: " + Arrays.toString(score));
            System.out.printf("심사위원 평균 점수: %.1f\n", avg);
            scanner.close();
        }
    }


