package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(input.substring(j-1, j));
            }
        }
        br.close();
        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});
        visited[1][1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 1 && nx <= n && ny >= 0 && ny <= m && map[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    map[nx][ny] = map[now[0]][now[1]] + 1;
                }
            }
        }
        System.out.println(map[n][m]);
    }
}