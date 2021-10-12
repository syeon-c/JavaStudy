package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        // dp[i]: arr[i] 마지막 항으로 하는 최대 증가 수열
        int[] dp = new int[n];
        int[] arr = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();

        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j] && dp[j] > max)
                    // arr[i]보다 작으면서 dp[j]가 최댓값인 경우
                    max = dp[j];
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}