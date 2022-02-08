package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        br.close();
        int[] dp = new int[A];

        for(int i = 0; i < A; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }
        int answer = 0;
        for(int value : dp) if (value > answer) answer = value;
        System.out.println(answer);
    }
}