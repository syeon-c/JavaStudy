package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ6588 {
    private static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 소수인지 체크하는 배열 isPrime[] 생성 --> 에라토스테네스의 체
        boolean[] isPrime = new boolean [MAX+1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= MAX; i++)
            isPrime[i] = true;
        for(int i = 2; i <= MAX; i++) {
            for(int j = i + i; j <= MAX; j += i) {
                if(!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
        while (true) {
            int N = Integer.parseInt(br.readLine());
            boolean ok = false;
            if (N == 0) break;
            for(int i = 2; i <= N/2; i++) {
                if(isPrime[i] && isPrime[N - i]) {
                    System.out.println(N + " = " + i + " + " + (N-i));
                    ok = true;
                    break;
                }
            }
            if (!ok) System.out.println("Goldbach's conjecture is wrong.");
        }
        br.close();
    }
}