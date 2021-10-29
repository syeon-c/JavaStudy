package Array;

/**
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 * 제한시간은 1초입니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array05 {
    private static void Solution(int n) {
        int[] arr = new int[n + 1];
        int answer = 0;
        for(int i = 2; i <= n; i++) {
            if(arr[i] == 0) {
                answer++;
                // i의 배수들 체크
                for(int j = i; j <= n; j = j + i)
                    arr[j] = 1;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        Solution(N);
    }
}