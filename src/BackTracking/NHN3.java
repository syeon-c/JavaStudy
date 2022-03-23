package BackTracking;

import java.util.Scanner;

public class NHN3 {
    private static boolean[] visited;
    private static int[] arr;
    private static int answer;

    public static void dfs(int i) {
        if(i == 9) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println(++answer);
            return;
        }

        for(int j = 1; j <= 8; j++) {
            if(!visited[j]) {
                visited[j] = true;
                arr[i] = j;
                dfs(i + 1);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] conflict = new int[4][2];

        visited = new boolean[9];
        arr = new int[9];
        answer = 0;

        dfs(1);
    }
}
