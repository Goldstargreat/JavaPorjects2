package w0827;

import java.util.Calendar;
import java.util.Random;

public class WiseSay {
    public static void main(String[] args) {
        String[] WiseSay = {
                "인생은 용기의 문제이지, 행운의 문제가 아니다.",

                "할 수 있다고 생각하든, 할 수 없다고 생각하든 당신이 옳다.",

                "성공은 최종적인 것이 아니며, 실패는 치명적인 것이 아니다. 중요한 것은 계속하려는 용기이다.",

                "가장 위대한 영광은 한 번도 실패하지 않는 것에 있는 것이 아니라, 실패할 때마다 다시 일어서는 것에 있다.",

                "미래는 현재 우리가 무엇을 하느냐에 달려있다.",

                "변화는 모든 진정한 학습의 최종 결과다.",

                "기회를 찾는 사람은 목표를 가지고 있으며, 기회를 기다리는 사람은 핑계를 가지고 있다.",

                "아무것도 하지 않으면 아무것도 일어나지 않는다.",

                "인생은 자전거를 타는 것과 같다. 균형을 잡으려면 계속 움직여야 한다.",

                "사람을 변화시키는 가장 좋은 방법은 그들의 생각을 바꾸는 것이다."
        };

        Random rand = new Random();

        int todayIndex = rand.nextInt(WiseSay.length);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.printf("%d년 %d월 %d일 오늘의 명언 ==>> %s\n", year, month, day, WiseSay[todayIndex]);
    }
}
