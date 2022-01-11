package DataStructure.Heap.Programmers;

import java.util.PriorityQueue;

public class Spicier {
    private static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 우선순위큐에 각 스코빌 지수값 삽입
        for(int s : scoville)
            heap.add(s);

        while (heap.peek() < K) {
            // 스코빌 지수 섞기
            int min1 = heap.poll();
            int min2 = heap.poll();

            heap.add(min1 + min2 * 2);
            answer++;

            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우 -1 리턴
            if (heap.peek() < K && heap.size() == 1) {
                answer = -1;
                break;
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
