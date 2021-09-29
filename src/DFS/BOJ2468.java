package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2468 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count;

    private static void bfs(int n, int r, int c, boolean[][] check) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        count = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nr = now[0];
            int nc = now[1];

            for(int i = 0; i < 4; i++) {
                int x = nr + dx[i];
                int y = nc + dy[i];
                if(x >= 1 && y >= 1 && x < n && y < n && !check[x][y]) {
                    check[x][y] = true;
                    queue.offer(new int[]{x, y});

                }
            }
        }
        count++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        List<Integer> levelList = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                int num = Integer.parseInt(input[j - 1]);
                map[i][j] = num;
                if(!levelList.contains(num)) levelList.add(num);
            }
        }
        Collections.sort(levelList);
        int answer = 0;
        for(int l : levelList) {
            boolean[][] check = new boolean[n + 1][n + 1];
            // 물 잠기기
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(map[i][j] <= l)
                        check[i][j] = true;
                }
            }
            // 안전 영역 탐색
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!check[i][j]) bfs(n, i, j, check);
                }
            }
        }
        answer = Math.max(answer, count);
    }
}
