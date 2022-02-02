package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] dp = new int[N];
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);

        dp[0] = 1;
        int answer = 1;
        for(int i = 1; i < N; i++) {
            int cnt = 0;
            for(int j = i-1; j >= 0; j--) {
                if (arr[i] > arr[j] && cnt < dp[j])
                    cnt = dp[j];
            }
            dp[i] = cnt + 1;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

        Stack<Integer> list = new Stack<>();
        for(int i = N - 1; i >= 0; i--) {
            if (dp[i] == answer) {
                list.push(arr[i]);
                answer--;
            }
        }
        while (!list.isEmpty()) System.out.print(list.pop() + " ");
    }
}
