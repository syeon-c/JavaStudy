package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        br.close();
        boolean[] check = new boolean[N + 1];
        check[0] = check[1] = true;
        for(int i = 2; i < N; i++) {
            if (check[i]) continue;
            // i의 배수 모두 소수에서 제하기
            for(int j = i + i; j <= N; j += i) {
                check[j] = true;
            }
        }
        for(int i = M; i <= N; i++) {
            if (!check[i]) System.out.println(i);
        }
    }
}