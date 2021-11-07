package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array12 {
    private static void Solution(int n, int m, int[][] map) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (i == j) continue;
                int cnt = 0;
                // 수학테스트 개수만큼 비교
                for(int k = 0; k < m; k++) {
                    int rank_i = 0, rank_j = 0;
                    // 수학테스트 당 학생들 등수 값 얻기
                    for(int s = 1; s <= n; s++) {
                        if (map[k][s] == i) rank_i = s;
                        if (map[k][s] == j) rank_j = s;
                    }
                    if (rank_i < rank_j) cnt++;
                }
                // 모든 수학테스트에서 i 가 j보다 앞설 때 > 멘토 멘티 성립
                if(cnt == m) answer++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[M][N + 1];
        for(int i = 0; i < M; i++) {
            String[] info = br.readLine().split(" ");
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(info[j - 1]);
            }
        }
        Solution(N, M, map);
    }
}
