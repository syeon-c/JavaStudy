package Programmers.Level2;

import java.util.PriorityQueue;

public class Spicier {
    private static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for(int s : scoville) foods.add(s);

        while (foods.peek() < K) {
            int min1 = foods.poll();
            int min2 = foods.poll();

            foods.add(min1 + min2 * 2);
            answer++;
            if (foods.size() == 1 && foods.peek() < K) {
                return -1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
