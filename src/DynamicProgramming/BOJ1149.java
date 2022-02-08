package DynamicProgramming;

/**
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
 * 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
 *
 * 1) 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * 2) N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * 3) i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] rgb = new int[n + 1][3];
        for(int i = 1 ; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 2부터 N까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더함
        for(int i = 2; i <= n; i++) {
            rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]);
            rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
            rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
        }
        // 모든 경우의 수(RGB) 중 최솟값 출력
        System.out.println(Math.min(rgb[n][0], Math.min(rgb[n][1], rgb[n][2])));
    }
}