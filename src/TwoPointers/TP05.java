package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 */

public class TP05 {
    private static void Solution(int n) {
        int answer = 0, sum = 0;
        // n을 2로 나눈 몫 + 1 까지만 더해주면 된다
        int k = n/ 2 + 1;
        // n / 2 + 1 까지의 값을 가진 배열 생성
        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = i + 1;
        }
        // TP04 참조
        int lp = 0;
        for(int rp = 0; rp < k; rp++) {
            sum += arr[rp];
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= arr[lp++];
                if (sum == n) answer++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Solution(N);
    }
}
