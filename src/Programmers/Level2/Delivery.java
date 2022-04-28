package Programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Delivery {
    private static class Node {
        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    private static int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 맵 초기화
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = 500001;
            }
        }
        for (int[] r : road) {
            map[r[0]][r[1]] = Math.min(map[r[0]][r[1]], r[2]);
            map[r[1]][r[0]] = Math.min(map[r[1]][r[0]], r[2]);
        }
        int[] visited = new int[N + 1];
        Arrays.fill(visited, 500001);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        visited[1] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i = 1; i <= N; i++) {
                if (map[now.destination][i] != 0 && map[now.destination][i] < 500001) {
                    if (visited[i] > now.cost + map[now.destination][i]) {
                        visited[i] = now.cost + map[now.destination][i];
                        queue.offer(new Node(i, now.cost + map[now.destination][i]));
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            if (visited[i] <= K) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int N = 6;
        int K = 4;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        System.out.println(solution(N, road, K));
    }
}
