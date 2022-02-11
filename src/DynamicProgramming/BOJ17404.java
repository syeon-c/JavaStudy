package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N][3];
        for(int i = 0 ; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();

        // 첫 번째 집을 Red로 칠한 경우
        int[][] dp = new int[N][3];
        dp[0][0] = rgb[0][0];
        dp[1][0] = Integer.MAX_VALUE;
        dp[1][1] = dp[0][0] + rgb[1][1];
        dp[1][2] = dp[0][0] + rgb[1][2];

        paintHouses(N, rgb, dp);
        int answer = Math.min(dp[N - 1][1], dp[N - 1][2]);

        // 첫 번째 집을 Green으로 칠한 경우
        dp = new int[N][3];
        dp[0][1] = rgb[0][1];
        dp[1][1] = Integer.MAX_VALUE;
        dp[1][0] = dp[0][1] + rgb[1][0];
        dp[1][2] = dp[0][1] + rgb[1][2];

        paintHouses(N, rgb, dp);
        answer = Math.min(answer, Math.min(dp[N-1][0], dp[N-1][2]));

        // 첫 번째 집을 Blue로 칠한 경우
        dp = new int[N][3];
        dp[0][2] = rgb[0][2];
        dp[1][2] = Integer.MAX_VALUE;
        dp[1][0] = dp[0][2] + rgb[1][0];
        dp[1][1] = dp[0][2] + rgb[1][1];

        paintHouses(N, rgb, dp);
        answer = Math.min(answer, Math.min(dp[N-1][0], dp[N-1][1]));

        System.out.println(answer);
    }

    private static void paintHouses(int N, int[][] rgb, int[][] dp) {
        for(int i = 2; i < N; i++) {
            dp[i][0] = rgb[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = rgb[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = rgb[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
    }
}