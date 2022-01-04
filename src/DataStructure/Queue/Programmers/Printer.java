package DataStructure.Queue.Programmers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    private static class Node {
        private int id, prior;

        public Node(int id, int prior) {
            this.id = id;
            this.prior = prior;
        }
    }
    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++)
            q.offer(new Node(i, priorities[i]));
        boolean canOut = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for(Node n : q) {
                if (n.prior > now.prior) {
                    q.offer(now);
                    canOut = false;
                    break;
                } else canOut = true;
            }
            if (canOut) {
                answer++;
                if (now.id == location) return answer;
            }

        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int loc = 0;
        System.out.println(solution(priorities, loc));
    }
}
