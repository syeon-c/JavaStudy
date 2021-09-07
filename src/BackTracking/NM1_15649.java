package BackTracking;

import java.util.Scanner;

public class NM1_15649 {
    private static boolean[] visited;
    private static int[] arr;

    public static void dfs(int n, int m, int i) {
        if(i == m) {
            for(int val : arr)
                System.out.print(val + " ");

            System.out.println();
            return;
        }

        for(int j = 0; j < n; j++) {
            if(!visited[j]) {
                visited[j] = true;
                arr[i] = j + 1;
                dfs(n, m , i + 1);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n];
        arr = new int[m];

        dfs(n, m, 0);
    }
}
