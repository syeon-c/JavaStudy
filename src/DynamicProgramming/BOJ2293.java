package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다.
 * 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오.
 * 각각의 동전은 몇 개라도 사용할 수 있다. 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
 */

public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        int[] dp = new int[k + 1];
        int[] coins = new int[n];
        for(int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());
        br.close();

        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[k]);
    }
}