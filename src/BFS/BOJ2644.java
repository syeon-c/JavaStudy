package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2644 {
    private static class Family {
        int name; int count;

        public Family(int name, int count) {
            this.name = name;
            this.count = count;
        }
    }
    static int bfs(int n, int start, int end, int[][] graph, boolean[] visited) {
        Queue<Family> queue = new LinkedList<>();
        queue.offer(new Family(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()) {
            Family curr = queue.poll();
            if(curr.name == end) return curr.count;

            for(int i = 1; i <= n; i++) {
                if(!visited[i] && graph[curr.name][i] == 1) {
                    visited[i] = true;
                    queue.offer(new Family(i, curr.count + 1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n : 사람 수, m : 관계 수, a / b : 구해야 할 촌수 관계
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int n1 = Integer.parseInt(info[0]);
            int n2 = Integer.parseInt(info[1]);
            graph[n1][n2] = graph[n2][n1] = 1;
        }
        br.close();
        boolean[] visited = new boolean[n + 1];
        System.out.println(bfs(n, a, b, graph, visited));
    }
}
