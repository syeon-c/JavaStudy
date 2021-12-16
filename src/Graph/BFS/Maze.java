package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    static int[][] maze = new int[8][8];
    static int[][] dis = new int[8][8];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        maze[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = n[0] + dx[i];
                int ny = n[1] + dy[i];
                if (nx > 0 && nx <= 7 && ny > 0 && ny <= 7 && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                    dis[nx][ny] = dis[n[0]][n[1]] + 1;
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
        bfs(1, 1);
        if (dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
