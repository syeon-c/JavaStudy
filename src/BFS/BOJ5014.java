package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5014 {
    static void bfs(int size, int now, int goal, int up, int down) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(now);
        int[] visited = new int[size + 1];
        Arrays.fill(visited, -1);
        visited[now] = answer;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if(curr == goal) {
                System.out.println(visited[curr]);
                return;
            }

            for(int i : new int[]{ curr + up, curr - down}) {
                if(i >= 1 && i <= size && visited[i] == -1) {
                    visited[i] = visited[curr] + 1;
                    queue.offer(i);
                }
            }
        }
        System.out.println("use the stairs");
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int f = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int g = Integer.parseInt(input[2]);
        int u = Integer.parseInt(input[3]);
        int d = Integer.parseInt(input[4]);

        bfs(f, s, g, u, d);
    }
}