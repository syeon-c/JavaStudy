package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calf1 {
    int[] dir = {1, -1, 5};
    Queue<Integer> queue = new LinkedList<>();

    public int BFS(int start, int goal) {
        int answer = 0;
        int[] visited = new int[1001];
        visited[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int now = queue.poll();

                if(now == goal) return answer;

                for(int d : dir) {
                    int x = now + d;
                    if(x >= 1 && x <= 10000 && visited[x] == 0) {
                        visited[x] = 1;
                        queue.offer(x);
                    }
                }
            }
            answer++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Calf1 calf = new Calf1();
        Scanner sc = new Scanner(System.in);
        int start =sc.nextInt();
        int end =sc.nextInt();
        System.out.println(calf.BFS(start, end));
    }
}
