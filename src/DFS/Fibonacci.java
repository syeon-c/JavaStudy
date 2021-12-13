package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    static int[] fib;
    private static int dfs(int n) {
        if (fib[n] > 0) return fib[n];
        if (n == 1 || n == 2) return fib[n] = 1;
        else {
            return fib[n] = dfs(n - 2) + dfs(n - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        // 배열 이용한 방법
        fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < n; i++)
            fib[i] = fib[i - 2] + fib[i - 1];

        for(int f : fib)
            System.out.print(f + " ");

        // 메모이제이션
        System.out.println();
        fib = new int[n + 1];
        dfs(n);
        for(int i = 1; i <= n; i++)
            System.out.print(fib[i] + " ");
    }
}
