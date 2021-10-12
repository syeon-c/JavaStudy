package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *준규는 N×M 크기의 미로에 갇혀있다. 미로는 1×1크기의 방으로 나누어져 있고, 각 방에는 사탕이 놓여져 있다.
 * 미로의 가장 왼쪽 윗 방은 (1, 1)이고, 가장 오른쪽 아랫 방은 (N, M)이다.
 * 준규는 현재 (1, 1)에 있고, (N, M)으로 이동하려고 한다.
 * 준규가 (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있고, 각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다.
 * 또, 미로 밖으로 나갈 수는 없다.
 * 준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수의 최댓값을 구하시오.
 */

public class BOJ11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] dp = new int[n+1][m+1];
        // 미로 정보 입력
        int[][] map = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        }
        // 현재 위치 + max{(r-1, c), (r, c-1), (r+1, c-1)}
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(Math.max(map[i][j] + dp[i - 1][j - 1], map[i][j] + dp[i - 1][j]), map[i][j] + dp[i][j - 1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}