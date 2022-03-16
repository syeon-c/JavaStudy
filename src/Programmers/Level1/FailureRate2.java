package Programmers.Level1;

import java.util.*;

public class FailureRate2 {
    private static List<Integer> solution(int N, int[] stages) {
        Map<Integer, Double> stageRate = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            stageRate.put(i, 0.0);
        }
        List<Integer> answer = new ArrayList<>(stageRate.keySet());
        int player_total = stages.length;

        for(int stage : stages) {
            if (stage <= N)
                stageRate.replace(stage, stageRate.get(stage) + 1);
        }

        for(int i = 1; i <= N; i++) {
            if (stageRate.get(i) != 0) {
                double rate = stageRate.get(i);
                stageRate.replace(i, stageRate.get(i) / player_total);
                player_total -= rate;
            }
        }
        Collections.sort(answer, (v1, v2) -> (stageRate.get(v2).compareTo(stageRate.get(v1))));
        return answer;
    }
    public static void main(String[] args) {
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};
        for(int i : solution(N, stages)) System.out.println(i);
    }
}
