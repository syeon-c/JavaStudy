package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] dp = new int[N + 1];
        int[] P = new int[N + 1];
        for (int i = 1; i <= N; i++) P[i] = Integer.parseInt(input[i - 1]);

        for(int i = 1; i <= N; i++) {
            dp[i] = P[i];
            for(int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
            }
        }
        System.out.println(dp[N]);
        br.close();
    }
}