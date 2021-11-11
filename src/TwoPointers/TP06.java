package TwoPointers;

/**
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변 경할 수 있습니다.
 * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은 1 1 0 0 '1 1 1 1 1 1 1 1' 0 1 이며 그 길이는 8입니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TP06 {
    private static void Solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lp = 0;
        for(int rp = 0; rp < n; rp++) {
            // 0 -> 1 로 변환, 변환 횟수 증가
            if (arr[rp] == 0) cnt++;
            // 변환 횟수가 k를 넘어가는지 체크
            while (cnt > k) {
                if (arr[lp] == 0) cnt--;
                lp++;                   // lp 증가하면서 0인 지점 찾기
            }
            answer = Math.max(answer, rp - lp + 1);
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Solution(N, K, arr);
    }
}
