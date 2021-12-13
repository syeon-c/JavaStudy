package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSBFS02 {
    static int C, N;
    static int[] dogs;
    static int answer;
    private static void dfs(int i, int total) {
        if(total > C) return;
        if(i == N) {
            answer = Math.max(answer, total);
        } else {
            dfs(i + 1, total + dogs[i]);
            dfs(i + 1, total);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        C = Integer.parseInt(info[0]);
        N = Integer.parseInt(info[1]);
        dogs = new int[N];
        for(int i = 0; i < N; i++) {
            dogs[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        dfs(0, 0);
        System.out.println(answer);
    }
}
