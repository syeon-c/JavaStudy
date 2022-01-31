package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // dp[2] = 2
        int[] dp = new int[n + 2];

        dp[1] = 1;
        dp[2] = 2;

        if(n >= 3) {
            for(int i = 3; i <= n; i++)
                // 두 칸씩 더하는 방법 * 한 가지 + 한 칸씩 더하는 방법 * 한 가지
                dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
        System.out.println(dp[n]);
        br.close();
    }
}
