package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Emoticon_14226 {
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
        int[] visited = new int[10001];
        Arrays.fill(visited, 0);
        queue.offer(new Emoticon(1, 0, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Emoticon em = queue.poll();

                if(em.count == goal) {
                    System.out.println(em.time);
                    return;
                }

                int nextCount; int nextCB;
                nextCount = em.count; nextCB = em.count;
                if(nextCount >= 1 && nextCount <= 1000) {
                    queue.offer(new Emoticon(nextCount, nextCB, em.time + 1));
                }

                nextCount = em.count + em.clipBoard; nextCB = em.clipBoard;
                if(nextCount >= 1 && nextCount <= 1000 && visited[nextCount] == 0) {
                    queue.offer(new Emoticon(nextCount, nextCB, em.time + 1));
                }

                nextCount = em.count - 1; nextCB = em.clipBoard;
                if(nextCount >= 1 && nextCount <= 1000 && visited[nextCount] == 0) {
                    queue.offer(new Emoticon(nextCount, nextCB, em.time + 1));
                }
            }
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s =  sc.nextInt();
        bfs(s);
    }
}
