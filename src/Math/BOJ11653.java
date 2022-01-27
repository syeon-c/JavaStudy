package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 소수 구하기
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= N; i++) {
            for(int j = i + i; j <= N; j += i) {
                if (!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
        int n = 2;
        while (N > 1) {
            if (isPrime[n]) {
                if (N % n == 0) {
                    System.out.println(n);
                    N /= n;
                } else {
                    n++;
                }
            } else n++;
        }
        br.close();
    }
}
