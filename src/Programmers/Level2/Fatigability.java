package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class Fatigability {
    static int max = Integer.MIN_VALUE;
    static int[][] g_dungeons;
    static int g_k;

    private static void searchRoute(List<Integer> route, boolean[] visited) {
        if (route.size() == visited.length) {
            countAvailableDungeons(route);
            return;
        }

        for(int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                route.add(i);
                searchRoute(route, visited);
                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static void countAvailableDungeons(List<Integer> route) {
        int fatigability = g_k;
        int cnt = 0;
        for(int d : route) {
            if (fatigability >= g_dungeons[d][0]) {
                fatigability -= g_dungeons[d][1];
                cnt++;
            }
        }
        max = Math.max(max, cnt);
    }

    private static int solution(int k, int[][] dungeons) {
        g_dungeons = dungeons;
        g_k = k;
        boolean[] visited = new boolean[dungeons.length];
        List<Integer> route = new ArrayList<>();
        // 경로 탐색
        searchRoute(route, visited);
        return max;
    }
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };
        System.out.println(solution(k, dungeons));
    }
}
