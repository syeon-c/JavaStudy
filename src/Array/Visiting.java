package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Visiting {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int solution(String dirs) {
        int answer = 0;
        // 상하좌우 4방향에서 들어올 수 있기 때문에 방문 표시 3차원 배열로 생성
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5, y = 5;
        int d;
        for(char dir : dirs.toCharArray()) {
            if (dir == 'U') {
                d = 0;
            } else if (dir == 'L') {
                d = 1;
            } else if (dir == 'D') {
                d = 2;
            } else {
                d = 3;
            }
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 범위 체크
            if (nx <= 0 && nx > 11 && ny <= 0 && ny > 11) {
                if (!visited[nx][ny][d]) {
                    visited[nx][ny][d] = true;
                    // 되돌아올 경우 대비 방문 표시
                    d = (d % 2 == 0) ? 2 - d : 4 - d;
                    visited[x][y][d] = true;
                    answer++;
                }
            }
            // 현재 위치 갱신
            x = nx;
            y = ny;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        solution(input);
    }
}
