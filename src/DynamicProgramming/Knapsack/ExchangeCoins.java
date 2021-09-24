package DynamicProgramming.Knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class ExchangeCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] dp = new int[m+1];

        System.out.println(solution(m, num, dp));
    }

    public static int solution(int m, int[] num, int[] dp) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < num.length; i++) {
            for(int j = num[i]; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - num[i]] + 1);
            }
        }
        return dp[m];
    }
}
