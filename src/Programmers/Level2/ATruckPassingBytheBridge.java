package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class ATruckPassingBytheBridge {
    private static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }
    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Truck> trucks = new LinkedList<>();

        for(int truck : truck_weights) {
            trucks.offer(new Truck(truck));
        }

        int total_weight = 0;
        while (!bridge.isEmpty() || !trucks.isEmpty()) {
            answer++;

            if (bridge.isEmpty()) {
                Truck t = trucks.poll();
                total_weight += t.weight;
                bridge.offer(t);
                continue;
            }

            for(Truck t : bridge)
                t.moving();

            if (bridge.peek().move > bridge_length) {
                Truck t = bridge.poll();
                total_weight -= t.weight;
            }

            if (!trucks.isEmpty() && total_weight + trucks.peek().weight <= weight) {
                Truck t = trucks.poll();
                total_weight += t.weight;
                bridge.offer(t);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(length, weight, truck_weights));
    }
}
