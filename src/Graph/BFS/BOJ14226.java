package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14226 {
    private static boolean[][] visited = new boolean[1001][1001];
    private static class Emoticon {
        private int screen;
        private int clipboard;
        private int time;

        public Emoticon(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    private static void bfs(int S) {
        Queue<Emoticon> queue = new LinkedList<>();
        queue.offer(new Emoticon(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Emoticon now = queue.poll();

                if(now.screen == S) {
                    System.out.println(now.time);
                    return;
                }

                // 1. 클립보드에 복사
                queue.offer(new Emoticon(now.screen, now.screen, now.time + 1));
                // 2. 복사한 이모티콘 화면에 붙여넣기
                if(now.screen != 0 && now.screen + now.clipboard >= S && !visited[now.screen + now.clipboard][now.clipboard]) {
                    visited[now.screen + now.clipboard][now.clipboard] = true;
                    queue.offer(new Emoticon(now.screen + now.clipboard, now.clipboard, now.time + 1));
                }
                // 3. 이모티콘 한 개 제거
                if(now.screen >= 1 && !visited[now.screen - 1][now.clipboard]) {
                    visited[now.screen - 1][now.clipboard] = true;
                    queue.offer(new Emoticon(now.screen - 1, now.clipboard, now.time + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        bfs(S);
    }
}
