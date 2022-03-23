package DynamicProgramming.Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++) {
            String[] wv = br.readLine().split(" ");
            w[i] = Integer.parseInt(wv[0]);
            v[i] = Integer.parseInt(wv[1]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                // i번째 무게를 담을 수 없는 경우
                if(w[i] > j) dp[i][j] = dp[i - 1][j];
                // i번째 무게를 담을 수 있는 경우
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);

            }
        }
        System.out.println(dp[n][k]);
    }
}
