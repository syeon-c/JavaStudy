package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n개의 정수로 이루어진 임의의 수열이 주어진다.
 * 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 * 단, 수는 한 개 이상 선택해야 한다.
 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
 * 여기서 정답은 12+21인 33이 정답이 된다.
 */

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input[i]);

        dp[0] = arr[0];
        int answer = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}