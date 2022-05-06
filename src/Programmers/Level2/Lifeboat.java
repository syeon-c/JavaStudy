package Programmers.Level2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Lifeboat {
    private static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int p : people) deque.add(p);

        while (!deque.isEmpty()) {
            int boat = deque.pollLast();
            if (!deque.isEmpty() && boat + deque.peekFirst() <= limit) {
                deque.pollFirst();
            }
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] people = {140, 40, 50, 150};
        int limit = 200;
        System.out.println(solution(people, limit));
    }
}
