package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
 * 그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은 몇 개라도 사용할 수 있다.
 * 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
 */

public class BOJ2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        // dp[i]: i 금액을 만드는 데에 드는 최소 동전의 개수
        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());

        br.close();

        dp[0] = 0;
        for(int coin : coins) {
            for(int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        // 촤소 개수를 구하지 못하는 경우 -1 출력
        if(dp[k] == k + 1)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}