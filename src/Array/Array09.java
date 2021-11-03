package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array09 {
    private static void Solution(int n, int[][] map) {
        int answer = Integer.MIN_VALUE;
        int sum_row, sum_col;
        for(int i = 0; i < n; i++) {
            sum_row = sum_col = 0;
            for(int j = 0; j < n; j++) {
                sum_col += map[i][j];
                sum_row += map[j][i];
            }
            answer = Math.max(answer, Math.max(sum_col, sum_row));
        }
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < n; i++) {
            sum1 = map[i][i];
            sum2 = map[i][n - i - 1];
        }
        answer = Math.max(answer, Math.max(sum1, sum2));

        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();
        Solution(N, map);
    }
}