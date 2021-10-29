package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array04 {
    private static void Solution(int n) {
        int[] fib = new int[n];
        fib[0] = 1; fib[1] = 1;
        for(int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for(int f : fib)
            System.out.print(f + " ");
    }
    // 배열 사용 안 함
    private static void Solution2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b; b = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        Solution(N);
        System.out.println();
        Solution2(N);
    }
}
