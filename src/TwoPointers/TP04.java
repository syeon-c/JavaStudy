package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TP04 {
    private static void Solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lp = 0;
        // 합이 m보다 작으면 rp 증가
        for(int rp = 0; rp < n; rp++) {
            sum += arr[rp];
            if (sum == m) answer++;
            // 합이 m보다 크거나 같으면 현재 lp가 가리키는 값 빼고, lp 증가
            while(sum >= m) {
                sum -= arr[lp++];
                if (sum == m) answer++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Solution(N, M, arr);
    }
}
