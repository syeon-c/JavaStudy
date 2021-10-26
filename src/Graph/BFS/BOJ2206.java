package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2206 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] visited;

    private static class Node {
        int x; int y;
        int cnt;        // 누적 거리
        int breakWall;  // 벽을 부순 횟수

        public Node(int x, int y, int cnt, int breakWall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakWall = breakWall;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1, 0));
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.x == N - 1 && now.y == M - 1)
                return now.cnt;

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] > now.breakWall) {
                    if(map[nx][ny] == 0) {
                        queue.offer(new Node(nx, ny, now.cnt + 1, now.breakWall));
                        visited[nx][ny] = now.breakWall;
                    } else {
                        if(now.breakWall == 0) {
                            queue.offer(new Node(nx, ny, now.cnt + 1, now.breakWall + 1));
                            visited[nx][ny] = now.breakWall + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        map = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        br.close();
        int answer = bfs(0, 0);
        System.out.println(answer);
    }
}
