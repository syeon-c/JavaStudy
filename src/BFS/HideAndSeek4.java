package BFS;

import java.util.*;

public class HideAndSeek4 {
    int answer = 0;
    int[] visited = new int[100001];

    public int bfs(int start, int goal) {
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);


        while (!q.isEmpty()) {
            int len = q.size();

            for(int i = 0; i < len; i++) {
                int now = q.poll();
                int[] dir = {now + 1, now - 1, now * 2};

                if(now == goal) return answer;

                for(int j = 0; j < 3; j++) {
                    if(dir[j] >= 0 && dir[j] <= 100000 && visited[dir[j]] == -1) {
                        visited[dir[j]] = now;
                        q.offer(dir[j]);
                    }
                }
            }
            answer++;
        }
        return 0;
    }


    public static void main(String[] args) {
        HideAndSeek4 hs = new HideAndSeek4();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int goal = sc.nextInt();

        if(start == goal) {

        }
        hs.bfs(start, goal);

        System.out.println(hs.answer);

        int[] result = new int[hs.answer + 1];
        int tmp = goal;
        for(int i = hs.answer; i >= 0; i--) {
            result[i] = tmp;
            tmp = hs.visited[tmp];
        }

        for(int i = 0; i < result.length; i++) {
            if(i == result.length - 1) System.out.print(result[i]);
            else System.out.print(result[i] + " ");
        }
    }
}
