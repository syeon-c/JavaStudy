package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array07 {
    private static void Solution(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        br.close();
        int[] solved = new int[N];
        for(int i = 0; i < N; i++) {
            solved[i] = Integer.parseInt(input[i]);
        }

        Solution(N, solved);
    }
}
