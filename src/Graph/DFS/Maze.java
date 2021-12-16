package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maze {
    static int[][] maze = new int[8][8];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer;
    private static void dfs(int x, int y) {
        if (x == 7 && y == 7) answer++;
        else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx > 0 && nx <= 7 && ny > 0 && ny <= 7 && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    dfs(nx, ny);
                    // 다시 되돌아가면서 0으로 값 돌리기
                    maze[nx][ny] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i < 8; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 1; j < 8; j++) {
                maze[i][j] = Integer.parseInt(input[j - 1]);
            }
        }
        br.close();
        maze[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }
}
