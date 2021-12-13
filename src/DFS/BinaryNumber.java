package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryNumber {
    private static void dfs(int n) {
        if (n == 0) return;
        else {
            dfs(n / 2);
            System.out.print(n % 2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        dfs(n);
    }
}
