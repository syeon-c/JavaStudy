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
        while (M <= N) {
            boolean isPrime = true;
            for(int i = 2; i < M; i++) {
                if (M % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.println(M);
            M++;
        }
    }
}