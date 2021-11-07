package Array;

/**
 * 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다. 김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
 * 그는 자 기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array11 {
    private static void Solution(int n, int[][] info) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            // i와 비교할 학생 j
            for(int j = 1; j <= n; j++) {
                if (i == j) continue;
                // 1학년부터 5학년까지 속했던 반의 정보 탐색
                for(int k = 1; k <= 5; k++) {
                    if (info[i][k] == info[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            // 다른 학생과 같은 반이었던 횟수가 기존 횟수(max)보다 많으면 max 수정
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N+1][6];
        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 5; j++) {
                info[i][j+1] = Integer.parseInt(input[j]);
            }
        }
        br.close();
        Solution(N, info);
    }
}
