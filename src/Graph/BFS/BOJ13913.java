package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ13913 {
    private static int answer = 0;
    private static int[] visited = new int[100001];

    private static int bfs(int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int now = q.poll();
                int[] dir = {now - 1, now +1, now * 2};

                if(now == goal) return answer;

                for(int next : dir) {
                    if(next >= 0 && next <= 100000 && visited[next] == -1) {
                        visited[next] = now;
                        q.offer(next);
                    }
                }
            }
            answer++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Arrays.fill(visited, -1);

        bfs(N, K);

        System.out.println(answer);

        int[] result = new int[answer + 1];
        int tmp = K;
        for(int i = answer; i >= 0; i--) {
            result[i] = tmp;
            tmp = visited[tmp];
        }

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
