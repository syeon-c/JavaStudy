package Programmers.Level1;

import java.util.Arrays;

public class Budget {
    private static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i : d) {
            if (budget - i >= 0) {
                budget -= i;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        System.out.println(solution(d, budget));
    }
}
