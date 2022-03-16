package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15652 {
    private static int[] arr;
    private static boolean[] visited;
    private static void dfs(int n, int m, int i) {
        if (i == m) {
            for(int val : arr) System.out.print(val + " ");
            System.out.println();
            return;
        }
        for(int j = 0; j < n; j++) {
            if (!visited[j]) {
                arr[i] = j + 1;
                dfs(n, m, i + 1);
                visited[j] = true;
                for(int z = j+1; z < n; z++) visited[z] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[m];
        visited = new boolean[n];

        dfs(n, m, 0);
    }
}
