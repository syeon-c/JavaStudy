package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        if(n >= 2) {
            for (int i = 2; i <= n; i++)
                dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[n]);
        br.close();
    }
}