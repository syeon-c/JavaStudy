package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        br.close();
        Solution(N, K);
        Solution2(N, K);
    }

    private static void Solution2(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++)
                queue.offer(queue.poll());
            queue.poll();
            if (queue.size() == 1) answer = queue.poll();
        }
        System.out.println(answer);
    }

    private static void Solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int cnt = 1;
        while (queue.size() > 1) {
            if (cnt == k) {
                queue.poll();
                cnt = 1;
            } else {
                queue.offer(queue.poll());
                cnt++;
            }
        }
        System.out.println(queue.peek());
    }
}
