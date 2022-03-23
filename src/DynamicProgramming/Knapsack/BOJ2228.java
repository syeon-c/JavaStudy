package DynamicProgramming.Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n번째 수가 구간 m에 포함되지 않은 경우 :
 *   dp[n][m] = dp[n-1][m]
 *   n-1번째 수가 구간 m에 포함된 경우의 최대 합(dp[n-1][m])과 동일하다.
 *
 * n번째 수가 구간 m에 포함된 경우 :
 *   dp[n][m] = max(dp[k][m-1]) + sum(arr[k+2] ~ arr[n]) (0 <= k <= n-2)
 */

public class BOJ2228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] dp = new int[n+1][m+1];

        // arr 값 입력 및 누적합 리스트 초기화
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + arr[i];
        }
        // dp[][] 배열 초기화
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }

        dp[1][1] = arr[1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // i번째 수가 구간 m에 포함되지 않는 경우
                dp[i][j] = dp[i - 1][j];

                int min = 0;
                if (j == 1)
                    min = -1;

                for (int k = i - 2; k >= min; k--) {
                    if (k < 0)
                        dp[i][j] = Math.max(dp[i][j], sum[i]);
                    else
                        dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + sum[i] - sum[k + 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
