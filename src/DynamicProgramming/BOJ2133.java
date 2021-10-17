package DynamicProgramming;

/**
 * https://mizzo-dev.tistory.com/entry/baekjoon2133
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if(n % 2 == 0) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            if(n >= 2) {
                dp[2] = 3;
            }

            if(n >= 4) {
                for(int i = 4; i <= n; i += 2) {
                    for(int j = 2; j <= i; j += 2) {
                        int k = j == 2 ? 3 : 2;
                        dp[i] += k * dp[i - j];
                    }
                }
            }

            System.out.println(dp[n]);

        } else {
            System.out.println(0);
        }
    }
}
