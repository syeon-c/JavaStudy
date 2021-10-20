package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2225 {
    private final static long DIV =  1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[][] dp = new long[K + 1][N + 1];

        for(int i = 0; i <= N; i++)
            dp[1][i] = 1;
        for(int i = 2; i <= K; i++) {
            for(int j = 0; j <= N; j++) {
                if(j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIV;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}