package DataStructure.Queue.Programmers;

import java.util.*;

public class Trucks {
    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        for(int t : truck_weights)
            trucks.offer(t);
        // 다리 상태 초기화
        for(int i = 0; i < bridge_length; i++)
            bridge.offer(0);

        int currentWeight = 0;
        while (!bridge.isEmpty()) {
            currentWeight -= bridge.peek();
            bridge.poll();
            // 모든 트럭이 다리를 건널 때
            if (trucks.isEmpty()) {
                answer += bridge_length;
                break;
            }
            else {
                // 다리의 무게를 넘지 않으면 트럭 투입
                if((currentWeight + trucks.peek()) <= weight) {
                    bridge.offer(trucks.peek());
                    currentWeight += trucks.peek();
                    trucks.poll();
                }// 다리의 무게를 넘으면 0 삽입
                else bridge.offer(0);
            }
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
