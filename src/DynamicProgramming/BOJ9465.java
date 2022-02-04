package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n + 1];
            int[][] sticker = new int[2][n + 1];
            int row = 0;
            // 스티커 점수 설정
            while (row <= 1) {
                String[] input = br.readLine().split(" ");
                for(int i = 0; i < n; i++) {
                    sticker[row][i + 1] = Integer.parseInt(input[i]);
                }
                row++;
            }
            // DP
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for(int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}