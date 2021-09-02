package BFS;

import java.util.*;

public class HideAndSeek2 {
    public void bfs(int start, int goal) {
        int time = 0;
        int count = 0;
        boolean[] visited = new boolean[100001];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int len = queue.size();
            time++;

            for(int i = 0; i < len; i++) {
                int now = queue.poll();
                visited[now] = true;

                for(int next : new int[]{now + 1, now - 1, now * 2}) {
                    if(next >= 0 && next <= 100000 && !visited[next]) {
                        if(next == goal) {
                            count++;
                            continue;
                        }
                        queue.offer(next);
                    }
                }
            }
            // cnt가 올라간건 최소시간에 도착했다는 것으로 이후 시간에 도착하는 것은 무의미하다.
            if(count != 0) queue.clear();
        }
        System.out.println(time);
        System.out.println(count);
    }

    public static void main(String[] args) {
        HideAndSeek2 hs = new HideAndSeek2();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        if(start == end) {
            System.out.println(0);
            System.out.println(1);
        } else hs.bfs(start, end);
    }
}
