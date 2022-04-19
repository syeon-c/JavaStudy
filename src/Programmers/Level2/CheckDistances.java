package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/** https://jisunshine.tistory.com/m/148
 *  모든 'P'점에 대해서 다음을 만족하면, true를 리턴한다.
 *
 *    - 1번 자리에 'P'가 오지 않고
 *    - 1번 자리에 'O'가 있고, 사방에 인접한 2번 자리에 'P'가 없다면
 */

public class CheckDistances {
    private static boolean bfs(int x, int y, String[] place) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || (nx == x && ny == y))
                    continue;

                int distance = Math.abs(nx - x) + Math.abs(ny - y);

                if (distance <= 2 && place[nx].charAt(ny) == 'P') {
                    return false;
                } else if (distance < 2 && place[nx].charAt(ny) == 'O') {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return true;
    }
    private static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; i++) {
            String[] place = places[i];
            boolean ok = true;

            for(int r = 0; r < 5 && ok; r++) {
                for(int c = 0; c < 5 && ok; c++) {
                    if (place[r].charAt(c) == 'P') {
                        if (!bfs(r, c ,place)) { ok = false; }
                    }
                }
            }
            answer[i] = ok ? 1 : 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        for(int a : solution(places)) System.out.print(a + " ");
    }
}
