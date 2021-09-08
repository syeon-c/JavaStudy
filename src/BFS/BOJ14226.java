package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14226 {
    // 행: 화면 있는 이모티콘 수, 열: 클립보 있는 이모티콘 수
    static boolean visited[][] = new boolean[1001][1001];
    static class Emoticon {
        int count;
        int clipBoard;
        int time;

        public Emoticon(int count, int clipBoard, int time) {
            this.count = count;
            this.clipBoard = clipBoard;
            this.time = time;
        }
    }

    public static void bfs(int goal) {
        Queue<Emoticon> queue = new LinkedList<>();
        queue.offer(new Emoticon(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Emoticon em = queue.poll();


                if(em.count == goal) {
                    System.out.println(em.time);
                    return;
                }

                // 1. 클립보드에 복사
                queue.offer(new Emoticon(em.count, em.count, em.time + 1));

                // 2. 복사한 이모티콘 붙여넣기
                if(em.clipBoard != 0 && em.count + em.clipBoard <= goal && !visited[em.count + em.clipBoard][em.clipBoard]) {
                    queue.offer(new Emoticon(em.count + em.clipBoard, em.clipBoard, em.time + 1));
                    visited[em.count + em.clipBoard][em.clipBoard] = true;
                }

                // 3. 이모티콘 -1 제거
                if(em.count >= 1 && !visited[em.count - 1][em.clipBoard]) {
                    queue.offer(new Emoticon(em.count - 1, em.clipBoard, em.time + 1));
                    visited[em.count - 1][em.clipBoard] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s =  sc.nextInt();
        bfs(s);
    }
}
