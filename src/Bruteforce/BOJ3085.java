package Bruteforce;

/**
 * https://zzang9ha.tistory.com/203
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    private static int N;
    private static int answer;

    private static void check(char[][] candy) {
        // 가로로 체크
        for(int i = 0; i < N; i++) {
            int cnt = 1;
            for(int j = 0; j < N-1; j++) {
                // 이전 사탕과 동일한 경우 -> 계속 먹는다
                if (candy[i][j] == candy[i][j + 1]) cnt++;
                // 이전 사탕과 다른 경우 -> 새로 먹어야 한다. 따라서 1로 초기화
                else  cnt = 1;
                // 사탕 최대 개수 저장
                answer = Math.max(answer, cnt);
            }
        }
        // 세로로 체크
        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 0; j < N-1; j++) {
                // 이전 사탕과 동일한 경우 -> 계속 먹는다
                if (candy[j][i] == candy[j+1][i]) count++;
                    // 이전 사탕과 다른 경우 -> 새로 먹어야 한다. 따라서 1로 초기화
                else  count = 1;
                // 사탕 최대 개수 저장
                answer = Math.max(answer, count);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] candy = new char[N][N];
        for(int i = 0; i < N; i++) {
            candy[i] = br.readLine().toCharArray();
        }
        // 가로로 인접한 두 사탕 교환 후 최대 사탕 개수 찾고 원위치
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                char tmp = candy[i][j];
                candy[i][j] = candy[i][j + 1];
                candy[i][j + 1] = tmp;
                // 가로세로 체크
                check(candy);
                // 이전에 교환한 사탕 복구
                tmp = candy[i][j];
                candy[i][j] = candy[i][j + 1];
                candy[i][j + 1] = tmp;
            }
        }
        // 세로로 인접한 두 사탕 교환 후 최대 사탕 개수 찾고 원위치
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                char tmp = candy[j][i];
                candy[j][i] = candy[j + 1][i];
                candy[j + 1][i] = tmp;
                // 가로세로 체크
                check(candy);
                // 이전에 교환한 사탕 복구
                tmp = candy[j][i];
                candy[j][i] = candy[j + 1][i];
                candy[j + 1][i] = tmp;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
