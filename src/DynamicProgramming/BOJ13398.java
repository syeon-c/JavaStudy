package DynamicProgramming;

/**
 *  https://steady-coding.tistory.com/181
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(input[i]);
        br.close();

        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = arr[0];
        int answer = arr[0];

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            // 특정 수를 제거할 경우에는 2가지 케이스를 고려해야 한다.
            // (1) i번째 수가 처음 제거되는 경우
            // -> 단순히 이전 최대 연속 합을 할당하면 됨.
            // (2) i번째 수 전에 지워진 수가 있는 경우
            // -> 현재 수는 지울 수 없으므로 이전 최대 연속 합에다가 arr[i]를 더함
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(answer);
    }
}
