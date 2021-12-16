package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
    static int M, N;
    static int[][] board, days;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                    // 익음 표시
                    board[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                    // 일수 표시
                    days[nx][ny] = days[x][y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        M = Integer.parseInt(info[0]);
        N = Integer.parseInt(info[1]);
        board = new int[N][M];
        days = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                int value = Integer.parseInt(input[j]);
                if(value == 1) q.offer(new int[]{i, j});
                board[i][j] = value;
            }
        }
        br.close();
        bfs();
        int answer = Integer.MIN_VALUE;
        boolean flag = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 0) flag = false;
            }
        }
        if (flag) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    answer = Math.max(answer, days[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }
}
