package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17103 {
    private static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 에라토스테네스의 체
        boolean[] isPrime = new boolean[MAX + 1];
        for(int i = 2; i <= MAX; i++)
            isPrime[i] = true;
        for(int i = 2; i <= MAX; i++) {
            for(int j = i + i; j <= MAX; j += i) {
                if(!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
        while (T-- > 0) {
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[n];
            for(int i = n-1; i >= 2; i--) {
                if (isPrime[i] && isPrime[n - i] && !check[i] && !check[n - i]) {
                    count++;
                    check[i] = check[n - i] = true;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}