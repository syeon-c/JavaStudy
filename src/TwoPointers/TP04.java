package TwoPointers;

/**
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 */

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
