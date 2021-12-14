package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSBFS06 {
    static int N, M;
    static int[] nums;
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
                    arr[i] = nums[j];
                    dfs(i + 1);
                    visited[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        arr = new int[M];
        nums = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        br.close();
        dfs(0);
    }
}
