package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 */

public class BOJ2178 {
    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, -1, 0, 1};

    static void bfs(int n, int m, int[][] maze, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int r = curr[0] + row[i];
                int c = curr[1] + col[i];
                // 범위 체크 및 방문 여부 체크
                if(r >= 0 && r < n && c >= 0 && c < m && maze[r][c] != 0 && !visited[r][c]) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                    maze[r][c] = maze[curr[0]][curr[1]] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] maze = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        br.close();
        boolean[][] visited = new boolean[n][m];
        bfs(n, m, maze, visited);
        System.out.println(maze[n-1][m-1]);
    }
}