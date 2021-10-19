package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7576 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                int value = Integer.parseInt(input[j]);
                map[i][j] = value;
                if(value == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        br.close();

        // BFS
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }
        // 모든 토마토가 익었는지 확인, 최대 일수 반환
        boolean flag = true;
        int answer = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0)
                    flag = false;
                else {
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        if(flag == false)
            System.out.println(-1);
        else
            System.out.println(answer - 1);
    }
}