package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16929 {
    private static int N;
    private static int M;
    private static int startX;
    private static int startY;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static boolean dfs(int x, int y, int count) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위 안에 있고, 시작점과 같은 색일 경우 탐색
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[x][y] == map[nx][ny]) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(dfs(nx, ny, count + 1)) return true;
                } else {
                    // 이미 방문한 지점이 첫번째 좌표와 같고 count가 4보다 크다 -> 조건에 맞는 싸이클이 형성되었다!
                    if(count >= 4 && startX == nx && startY == ny) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        br.close();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                startX = i; startY = j;
                if(dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}