package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1번부터 N번까지이다.
 */

public class BOJ1260 {
    static void DFS(int size, int start, int[][] graph, int[] visited) {
        visited[start] = 1;
        System.out.print(start + " ");

        for(int i = 1; i <= size; i++) {
            if(graph[start][i] == 1 && visited[i] != 1)
                DFS(size, i, graph, visited);
        }
    }

    static void BFS(int size, int start, int[][] graph, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.print(tmp + " ");

            for(int i = 1; i <= size; i++) {
                if(graph[tmp][i] == 1 && visited[i] != 1) {
                    queue.offer(i);
                    visited[i] = 1;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            graph[a][b] = graph[b][a] = 1;
        }

        int[] visited = new int[10001];

        br.close();

        DFS(n, v, graph, visited);
        System.out.println();
        Arrays.fill(visited, 0);
        BFS(n, v, graph, visited);
    }
}
