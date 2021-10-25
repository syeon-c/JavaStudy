package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16947 {
    private static int N;
    private static boolean[] visited;
    private static int[] distance;
    private static boolean isCycle;
    private static Queue<Integer> queue = new LinkedList<>();

    private static void dfs(ArrayList<Integer>[] graph, int pre, int now) {
        visited[now] = true;
        for(int next : graph[now]) {
            // next가 직전 방문지가 아니면서 이미 방문한 적 있음 -> 순환선
            if (visited[next] && next != pre) {
                isCycle = true;
                distance[next] = 0;
                queue.offer(next);
                break;
            // 아직 방문하지 않은 역 탐색
            } else if (!visited[next]) {
                dfs(graph, now, next);
                // 탐색한 역이 순환역일 경우
                if(isCycle) {
                    if(distance[next] == 0) {
                        isCycle = false;
                    } else {
                        distance[next] = 0;
                        queue.offer(next);
                    }
                    return;
                }
            }
        }
    }

    private static void bfs(ArrayList<Integer>[] graph) {
        int cnt = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                int tmp = queue.poll();
                // 연결된 구간을 다음 탐색지에 추가
                for (int i : graph[tmp]) {
                    // 거리가 이미 구해진 역은 제외
                    if (distance[i] != -1) continue;
                    distance[i] = cnt;
                    queue.add(i);
                }
            }
            cnt++; // 순환선과의 거리
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        // 연결 구간 정보 입력
        ArrayList<Integer> graph[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        // 그래프에서 순환선 찾기
        dfs(graph, 0, 1);
        // 역과 순환선의 거리 구하기
        bfs(graph);
        for(int i = 1; i <= N; i++) {
            System.out.print(distance[i] + " ");
        }
    }
}
