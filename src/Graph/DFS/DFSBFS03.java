package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSBFS03 {
    private static int N, M;
    private static int answer;
    private static class Prob {
        int score;
        int time;

        public Prob(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    private static void dfs(int i, int total_score, int total_time, Prob[] arr) {
        if (total_time > M) return;
        if (i == N) {
            answer = Math.max(answer, total_score);
        } else {
            dfs(i + 1, total_score + arr[i].score, total_time + arr[i].time, arr);
            dfs(i + 1, total_score, total_time, arr);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        Prob[] arr = new Prob[N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            arr[i] = new Prob(s, t);
        }
        br.close();
        dfs(0, 0, 0, arr);
        System.out.println(answer);
    }
}
