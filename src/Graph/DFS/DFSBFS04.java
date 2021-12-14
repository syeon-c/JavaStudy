package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSBFS04 {
    static int N, M;
    static int[] arr;

    private static void dfs(int i) {
        if (i == M) {
            for(int a : arr) System.out.print(a + " ");
            System.out.println();
        } else {
            for(int j = 1; j <= N; j++) {
                arr[i] = j;
                dfs(i + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        arr = new int[M];
        br.close();
        dfs(0);
    }
}