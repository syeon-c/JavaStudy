package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] house;

    private static void bfs(int x, int y, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        visited[x][y] = true;
        house[count]++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    house[count]++;
                }
            }
        }
    }

    private static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        house[count]++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        int count = 0;
        house = new int[n * n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, count);
                    count++;
                }
            }
        }
        Arrays.sort(house);

        System.out.println(count);
        for(int h : house)
            if(h != 0)
                System.out.println(h);
    }
}