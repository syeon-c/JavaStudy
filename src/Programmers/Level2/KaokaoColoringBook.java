package Programmers.Level2;

public class KaokaoColoringBook {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    private static void dfs(int m, int n, int[][] board, boolean[][] visit, int value, int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == value && !visit[nx][ny]) {
                visit[nx][ny] = true;
                count++;
                dfs(m, n, board, visit, value, nx, ny);
            }
        }
    }
    private static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    dfs(m, n, picture, visited, picture[i][j], i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(m, n, picture);
    }
}
