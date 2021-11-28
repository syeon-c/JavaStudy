package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue03 {
    private static class Node {
        int order; int prior;

        public Node(int order, int prior) {
            this.order = order;
            this.prior = prior;
        }
    }
    private static void Solution(int n, int m, int[] prior) {
        int answer = 1;
        Queue<Node> queue = new LinkedList<>();
        // 대기 목록 생성
        for(int i = 0; i < n; i++) {
            queue.offer(new Node(i, prior[i]));
        }

        while (!queue.isEmpty()) {
            boolean getTreatment = true;
            Node now = queue.poll();
            for(Node node : queue) {
                if (now.prior < node.prior) {
                    queue.offer(now);
                    getTreatment = false;
                    break;
                }
            }
            if (getTreatment) {
                if (now.order == m) {
                    System.out.println(answer);
                    return;
                }
                else answer++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        int[] priority = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            priority[i] = Integer.parseInt(input[i]);
        }
        br.close();
        Solution(N, M, priority);
    }
}
