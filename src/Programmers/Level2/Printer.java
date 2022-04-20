package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    private static class Node {
        int loc;
        int prior;

        public Node(int loc, int prior) {
            this.loc = loc;
            this.prior = prior;
        }
    }
    private static int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Node(i, priorities[i]));
        }

        boolean canOut = true;
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            for(Node node : queue) {
                if (front.prior < node.prior) {
                    queue.offer(front);
                    canOut = false;
                    break;
                }
            }
            if (canOut) {
                if (front.loc == location) {
                    return answer;
                } else answer++;
            } else canOut = true;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prior = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(prior, location));
    }
}
