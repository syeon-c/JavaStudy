package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11055 {
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
        dp[0] = arr[0];
        int answer = dp[0];

        for(int i = 1; i < A; i++) {
            int value = 0;
            for(int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j] && value < dp[j]) value = dp[j];
            }
            dp[i] = value + arr[i];
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}