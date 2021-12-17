package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Island {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<int[]> q = new LinkedList<>();
    static int N;
    static int[][] board;

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] n = q.poll();
            int x = n[0];
            int y = n[1];

            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 1) {
                    // 방문 표시
                    board[nx][ny] = 0;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();
        int answer = 0;
        // 섬 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    q.offer(new int[]{i, j});
                    // 방문 표시
                    board[i][j] = 0;
                    bfs();
                }
            }
        }
        System.out.println(answer);
    }
}
