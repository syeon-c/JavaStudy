package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
    final static long DIV = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][11];

        for(int i = 1; i <= 9; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            for(int j = 1; j <= 9; j++)
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % DIV;
        }

        long sum = 0;
        for(long i : dp[n])
            sum += i;

        System.out.println(sum % DIV);
    }
}