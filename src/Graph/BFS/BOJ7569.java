package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7569 {
    static Queue<Tomato> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    private static class Tomato {
        int h;
        int x;
        int y;

        public Tomato(int num, int x, int y) {
            this.h = num;
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs(int[][][] box, int n, int m, int h) {
        int answer = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Tomato curr = q.poll();

            for (int i = 0; i < 6; i++) {
                int height = curr.h + dh[i];
                int row = curr.x + dx[i];
                int col = curr.y + dy[i];

                if (height >= 1 && height <= h && row >= 1 && row <= n &&
                        col >= 1 && col <= m && box[height][row][col] == 0) {
                    q.offer(new Tomato(height, row, col));
                    box[height][row][col] = box[curr.h][curr.x][curr.y] + 1;
                }
            }
        }
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= m; k++){
                    if(box[i][j][k] == 0)
                        return -1;
                    else
                        answer = Math.max(answer, box[i][j][k]);
                }
            }
        }
        return answer - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);

        int[][][] box = new int[h + 1][n + 1][m + 1];
        // 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타냄
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                String[] info = br.readLine().split(" ");
                for (int k = 1; k <= m; k++) {
                    box[i][j][k] = Integer.parseInt(info[k-1]);
                    if (box[i][j][k] == 1) q.add(new Tomato(i, j, k));
                }
            }
        }
        System.out.println(bfs(box, n, m, h));
    }
}