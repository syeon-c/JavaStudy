package Math;

/**
 * 팩토리얼이 결국 곱으로 이루어진 연산이기 때문에 그리고 0은 10을 얼마나 곱하느냐에 따라 결정이 되기 때문에
 * 팩토리얼을 이루는 수의 소인수 중에서 2와 5의 개수에 따라 결정이 된다.
 * 정리를 하면
 *
 * N! = 1 x 2 x 3 x ... x N
 *
 * ex) 10! = 3628800
 *
 * 10! = 1 x 2 x 3 x 4 x 5 x 6 x 7 x 8 x 9 x 10
 *
 * 10! = 1 x 2 x 3 x (2 x 2) x 5 x (2 x 3) x 7 x (2 x 2 x 2) x (3 x 3) x (2 x 5)
 *
 * 10! = 2^8 x 3^4 x 5^2 x 7
 *
 * 10! = (2^2 x 5^2) x 2^6 x 3^4 x 7
 *
 * 10! = 10^2 x 2^6 x 3^4 x 7
 *
 * 2와 5의 개수 중 작은 값이 10의 개수 (0의 개수)가 된다.
 *
 * 따라서 0의 개수를 구할 때에는 2의 개수와 5의 개수를 구하고 그 중 작은 값이 결과값이 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int cntTwo = 0;
        int cntFive = 0;
        for(int i = 2; i <= N; i *= 2) cntTwo += N / i;
        for(int i = 5; i <= N; i *= 5) cntFive += N / i;

        System.out.println(Math.min(cntTwo, cntFive));
    }
}
