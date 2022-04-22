package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    private static int n, m;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static class Node {
        int x, y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.value;
            }

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] != 0 && !visited[nx][ny]) {
                    queue.offer(new Node(nx, ny, node.value + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        System.out.println(solution(maps));
    }
}
