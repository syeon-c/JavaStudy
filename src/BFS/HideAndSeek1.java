package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek1 {
    public int bfs(int start, int goal) {
        int answer = 0;
        int[] visited = new int[100001];
        visited[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int now = queue.poll();

                if(now == goal) return answer;

                for(int next : new int[]{now + 1, now - 1, now * 2}) {
                    int x = next;
                    if(x >= 0 && x <= 100000 && visited[x] == 0) {
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
        HideAndSeek1 hs = new HideAndSeek1();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(hs.bfs(start, end));
    }
}
