package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1520 {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] dp;

    private static int dfs(int x, int y) {
        if(x == 0 && y == 0)
            return 1;

        if(dp[x][y] == -1) {
            // 방문 처리
            dp[x][y] = 0;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(map[x][y] < map[nx][ny])
                        dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        map = new int[n][m];
        dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                // 방문 여부 표시
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(n-1, m-1));
    }
}