package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class FunctionalDevelopment {
    private static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] takes = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            takes[i] = (int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
        }

        int day = takes[0];
        int cnt = 1;
        for(int i = 1; i < takes.length; i++) {
            if (takes[i] > day) {
                day = takes[i];
                answer.add(cnt);
                cnt = 1;
            } else cnt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] progresses = {};
        int[] speeds = {};
        for(int n : solution(progresses, speeds)) System.out.print(n + " ");
    }
}
