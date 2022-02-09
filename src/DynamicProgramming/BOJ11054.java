package DynamicProgramming;

/**
 * https://fbtmdwhd33.tistory.com/56
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        br.close();

        // 왼쪽부터 시작하는 LIS
        int[] l_LIS = new int[N];
        for(int i = 0; i < N; i++) {
            l_LIS[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && l_LIS[i] < l_LIS[j] + 1) l_LIS[i] = l_LIS[j] + 1;
            }
        }
        // 오른쪽부터 시작하는 LIS
        int[] r_LIS = new int[N];
        for(int i = N - 1; i >= 0; i--) {
            r_LIS[i] = 1;
            for(int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && r_LIS[i] < r_LIS[j] + 1) r_LIS[i] = r_LIS[j] + 1;
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if (answer < l_LIS[i] + r_LIS[i]) answer = l_LIS[i] + r_LIS[i];
        }
        System.out.println(answer - 1);
    }
}