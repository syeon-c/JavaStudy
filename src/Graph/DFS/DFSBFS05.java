package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSBFS05 {
    static int N, M;
    static int[] coins;
    static int answer = Integer.MAX_VALUE;
    private static void dfs(int i, int value) {
        if (value > M) return;
        if (i >= answer) return;
        if (value == M) {
            answer = Math.min(answer, i);
        } else {
            for(int c : coins)
                dfs(i + 1, value + c);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coins = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(input[i]);
        M = Integer.parseInt(br.readLine());
        br.close();
        dfs(0, 0);
        System.out.println(answer);
    }
}
