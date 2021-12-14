package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSBFS09 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    private static void dfs(int i) {
        if (i == M) {
            for(int a : arr) System.out.print(a + " ");
            System.out.println();
        } else {
            for(int j = 0; j < N; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    arr[i] = j + 1;
                    dfs(i + 1);
                    for(int z = j + 1; z < N; z++)
                        visited[z] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        arr = new int[M];
        visited = new boolean[N];
        br.close();
        dfs(0);
    }
}
