package Array;

/**
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자 판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
 * 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array10 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static void Solution(int n, int[][] map) {
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                boolean isTop = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    // 상하좌우 값이 더 크면 break
                    if (map[nx][ny] >= map[i][j]) {
                        isTop = false;
                        break;
                    }
                }
                if(isTop) answer++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 2][N + 2];
        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j + 1] = Integer.parseInt(input[j]);
            }
        }
        br.close();
        Solution(N, map);
    }
}
