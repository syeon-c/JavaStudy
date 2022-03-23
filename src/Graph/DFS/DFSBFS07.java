package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSBFS07 {
    static int N, R;
    static int[][] memory = new int[34][34];

    private static int dfs(int n, int r) {
        // 메모이제이션
        if (memory[n][r] > 0) return memory[n][r];
        if (n == r || r == 0) return 1;
        else return memory[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        R = Integer.parseInt(info[1]);
        System.out.println(dfs(N, R));

    }
}
