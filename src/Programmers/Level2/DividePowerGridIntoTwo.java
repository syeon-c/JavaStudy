package Programmers.Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DividePowerGridIntoTwo {
    private static List<Integer>[] tree;
    private static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 1. 트리 생성
        tree = new List[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        // 2. bfs 탐색
        // 인접 리스트를 하나씩 끊어가면서 더 최소 개수의 차이 탐색
        for(int[] wire : wires) {
            int tower1 = bfs(wire[0], wire[1], n);
            int tower2 = bfs(wire[1], wire[0], n);
            answer = Math.min(answer, Math.abs(tower1 - tower2));
        }
        return answer;
    }

    private static int bfs(int node1, int node2, int n) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.offer(node1);
        visited[node1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;

            for(int next : tree[node]) {
                if (next != node2 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(n, wires));
    }
}
