package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15990 {
    static final int NUM = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % NUM;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % NUM;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % NUM;
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long answer = (dp[n][1] + dp[n][2] + dp[n][3]) % NUM;
            System.out.println(answer);
        }
        br.close();
    }
}
