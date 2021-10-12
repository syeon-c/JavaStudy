package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1890 {
    private static long[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][n+1];

        map = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                map[i][j] = Long.parseLong(input[j-1]);
            }
        }
        br.close();

        dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dp[i][j] == 0 || (i == n && j == n)) continue;

                long value = map[i][j];
                int dx = i + (int)value;
                int dy = j + (int)value;

                if(dx <= n) dp[dx][j] += dp[i][j];
                if(dy <= n) dp[i][dy] += dp[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }
}