package Graph.DFS;

/**
 * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 * 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 *
 * A는 B와 친구다.
 * B는 C와 친구다.
 * C는 D와 친구다.
 * D는 E와 친구다.
 *
 * 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ13023 {
    private static ArrayList<ArrayList<Integer>> arr;
    private static boolean[] visited;
    private static boolean ABCDE;

    private static void dfs(int start, int count) {
        if(count == 5) {
            ABCDE = true;
            return;
        }

        visited[start] = true;
        for(int f : arr.get(start)) {
            if(!visited[f])
                dfs(f, count + 1);
            if(ABCDE) return;
        }
        visited[start] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        // 사람 별 List 생성
        arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }
        // 입력 받은 친구 관계 List에 추가
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            int friend = Integer.parseInt(input[1]);
            arr.get(index).add(friend);
            arr.get(friend).add(index);
        }
        //DFS
        visited = new boolean[N];
        ABCDE = false;
        for(int i = 0; i < N; i++) {
            // 방문 표시 초기화
            Arrays.fill(visited, false);
            dfs(i, 1);
            if(ABCDE) break;
        }
        System.out.println(ABCDE ? 1 : 0);
    }
}