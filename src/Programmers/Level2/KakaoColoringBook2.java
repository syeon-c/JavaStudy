package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoColoringBook2 {
    // answer[0] 영역의 개수, answer[1] 가장 큰 영역의 칸 수
    private static int[] answer = new int[2];
    private static boolean[][] visited;
    private static void bfs (int m, int n, int x, int y, int[][] picture, boolean[][] visited, int cnt) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        picture[now[0]][now[1]] == picture[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        answer[1] = Math.max(answer[1], cnt);
    }
    private static int[] solution(int m, int n, int[][] picture) {
        answer[0] = 0; answer[1] = 0;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int cnt = 1;
                    answer[0]++;
                    visited[i][j] = true;
                    bfs(m, n, i, j, picture, visited, cnt);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        solution(m, n, picture);
    }
}
