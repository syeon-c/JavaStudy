package Graph.DFS;

/**
 * 연결 요소란, 무방향 그래프에서 적어도 한 개 이상의 경로로 연결된 정점들로 구성된 종속 그래프
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11724 {
    static int n; static int m;
    static int[][] graph;
    static boolean[] visited;

    private static void dfs(int node) {
        visited[node] = true;
        for(int i = 1; i <= n; i++) {
            if(graph[node][i] == 1 && !visited[i])
                dfs(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
