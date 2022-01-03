package DataStructure.Queue.Programmers;

import java.util.*;

public class p01 {
    private static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            // 분모(speeds값)를 double 처리 해주지 않으면 int형으로 자동 변환되기 때문에 Math.ceil() 함수가 적용되지 않는다!
            days[i] = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
        }
        int time = days[0];
        int count = 1;
        for(int i = 1; i < days.length; i++) {
            if (time < days[i]) {
                answer.add(count);
                count = 1;
                time = days[i];
            } else count++;
        }
        answer.add(count);
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {100, 40, 64};
        int[] speeds = {1, 2, 3};
        System.out.println(solution(progresses, speeds));
    }
}