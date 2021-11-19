package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek3 {
    static class Info {
        int pos;
        int time;

        public Info(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public int bfs(int start, int goal) {
        int answer = Integer.MAX_VALUE;
        boolean[] visited = new boolean[100001];
        visited[start] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();


            if (now.pos == goal) {
                return Math.min(answer, now.time);
            }

            int next;
            next = now.pos * 2;
            if (next >= 0 && next <= 100000 && !visited[next]) {
                visited[next] = true;
                queue.offer(new Info(next, now.time));
            }

            next = now.pos + 1;
            if (next >= 0 && next <= 100000 && !visited[next]) {
                visited[next] = true;
                queue.offer(new Info(next, now.time + 1));
            }


            next = now.pos - 1;
            if (next >= 0 && next <= 100000 && !visited[next]) {
                visited[next] = true;
                queue.offer(new Info(next, now.time + 1));
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        HideAndSeek3 hs = new HideAndSeek3();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int goal = sc.nextInt();

        if(start == goal) {
            System.out.println(0);
        } else System.out.println(hs.bfs(start, goal));
    }
}